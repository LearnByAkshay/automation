package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath=("//a[text()='Login & Signup']"))
	public WebElement LoginAndSignupButton;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void login(){
		LoginAndSignupButton.click();
	}

}
