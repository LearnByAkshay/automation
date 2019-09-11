package testCases.loginTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.HomePage;

import testBase.TestBase;

public class Login extends TestBase{
	
private static final TimeUnit SECONDS = null;

	@Test(priority=0)
	public void loginToFlipkart(){
		HomePage object = new HomePage(driver);
		object.login();
	}
	
//	@Test(groups="Sanity", priority=2)
//	public void test(){
//		System.out.println("I am here 1");
//		Assert.assertTrue(true);
//	}
//	
//	@Test(groups= {"Sanity","Smoke"}, priority=0)
//	public void test1(){
//		System.out.println("I am here 2");
//	}
//	
//	@Test(groups= {"Smoke"})
//	public void test2(){
//		System.out.println("I am here 3");
//	}
	
	@Test(groups= {"assert"}, priority=0)
	@Parameters({"paramOne", "paramTwo"})
	public void softAssert(@Optional("One") String paramOne, @Optional("Two") String paramTwo ){
//		SoftAssert softAssertion= new SoftAssert();
//		System.out.println("softAssert Method Was Started");
//		softAssertion.assertTrue(false);
//		System.out.println("softAssert Method Was Executed");
//		softAssertion.assertAll();
		
		System.out.println("Parameter One: "+paramOne+" Parameter Two: "+paramTwo);
	}
	
	@Test(groups= {"assert"}, priority=0,dataProvider="testData")
	public void hardAssert(String s1, String s2){
		System.out.println(" "+s1+" "+s2);
//		Assert.assertTrue(false);
		System.out.println("hardAssert Method Was Executed");
	}
	
	@DataProvider
	public Object[][] testData(){
		Object [][] data = new Object[3][2];
		data[0][0]="Swami";
		data[0][1]= "Om";
		data[1][0]="Swamii";
		data[1][1]= "Om";
		
		return data;
	}


}
