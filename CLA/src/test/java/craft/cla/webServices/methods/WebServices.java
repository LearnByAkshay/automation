package craft.cla.webServices.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class WebServices {
	
	public static Response Get(String uRI){
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response =requestSpecification.get(uRI);
		return response;
	} 

}
