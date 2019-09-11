package helper.verificationHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class VerificationHelper {
	
	private static Logger verificationLogger = Logger.getLogger(VerificationHelper.class);
	
	public static synchronized boolean isElementDisplay(WebElement ele){
		boolean isElementDisplay = false;
		try{
			isElementDisplay=ele.isDisplayed();
		}catch (NoSuchElementException e){
			verificationLogger.info("Element Not Found"+e);
		}
		return isElementDisplay;
	}
	
	public static synchronized boolean isElementNotDisplayed(WebElement ele){
		boolean isElementDisplay = false;
		try{
			isElementDisplay=ele.isDisplayed();
		}catch (NoSuchElementException e){
			verificationLogger.info("Element Not Found"+e);
			isElementDisplay = true;
		}
		return isElementDisplay;
	}
	
	public static synchronized boolean verifyTextEqual(String expectedText, WebElement ele){
			try{
				boolean flag = false;
				String actualText = ele.getText();
				if(actualText.equals(expectedText)){
					verificationLogger.info("Expected text is"+expectedText+"Actula text is"+actualText);
					flag = true;
					return flag;
				}else{
					verificationLogger.error("Expected text is"+expectedText+"Actula text is"+actualText);
					return flag;
				}
	
			}catch(NoSuchElementException ex){
				System.out.println("Element Not Found"+ex);
				return false;
			}
					
		}

}
