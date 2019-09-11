package craft.cla.testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;

import craft.cla.pojo.VerifyBaseMoney;
import craft.cla.utills.EndPointURL;
import craft.cla.utills.URL;
import craft.cla.webServices.methods.WebServices;

public class TC_001 {
	Response response;

	@Test
	public void verifyBaseMoneyForCountry() {
		Gson gson = new GsonBuilder().create();
		VerifyBaseMoney verify[];
		String url = URL.fixURL + EndPointURL.Argentina.getResourcePath();
		response = WebServices.Get(url);
//		System.out.println("Response Header"+response.headers());
		verify = gson.fromJson(response.getBody().asString(), VerifyBaseMoney[].class);
		Assert.assertEquals("5ba651504ad8714da42465fa", verify[0].getInternalId());
	}

}
