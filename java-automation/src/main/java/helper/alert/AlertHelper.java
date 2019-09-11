package helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class AlertHelper {
	
	private WebDriver driver;
	private Logger alertLogger = Logger.getLogger(AlertHelper.class);
		
	public AlertHelper(WebDriver driver) {
//		super();
		this.driver = driver;
	}

	public Alert getAlert(){
		alertLogger.info("Focus switched to alert");
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		alertLogger.info("alert accpeted");
		getAlert().accept();
	}
	
	public void dismissAlert(){
		alertLogger.info("Alert dismissed");
		getAlert().dismiss();
	}
	
	public String getAlertText(){
		alertLogger.info("Alert message captured");
		return getAlert().getText();
	}
	
	public boolean isAlertPresent(){
		
		try{
			getAlert();
			return true;
		}
		catch(NoAlertPresentException e){
			return false;
		}
	}

}
