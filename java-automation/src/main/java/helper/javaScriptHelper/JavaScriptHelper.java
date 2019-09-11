package helper.javaScriptHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaScriptHelper {
	private WebDriver driver;
	private static Logger JavaScriptHelper = Logger.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		JavaScriptHelper.info("Executing Script");
		return exe.executeScript(script);
	}
	
	public Object executeScript(String script,Object...args){
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		JavaScriptHelper.info("Executing Script");
		return exe.executeScript(script);
	}
	
	public void scrollToElement(WebElement ele){
		executeScript("window.scrollTo(arguments[0], arguents[1])", ele.getLocation().x, ele.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement ele){
		scrollToElement(ele);
		ele.click();
	}
	
	public void scrollIntoView(WebElement ele){
		executeScript("arguments[0].scrollIntoView()",ele);
	}
	
	public void scrollintoViewAndClick(WebElement ele){
		scrollIntoView(ele);
		ele.click();
	}
	
	public void scrollDownVertically(){
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollUpVertically(){
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	
}
