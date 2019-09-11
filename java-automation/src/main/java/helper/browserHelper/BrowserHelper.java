package helper.browserHelper;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BrowserHelper {

	private WebDriver driver;

	private static Logger browserLooger = Logger.getLogger(BrowserHelper.class);

	public BrowserHelper(WebDriver driver) {
		super();
		this.driver = driver;
		browserLooger.debug("Browser Helper" + this.driver.hashCode());
	}

	public void goBack() {
		driver.navigate().back();
		browserLooger.info("Successfully navigated to previous page");
	}

	public void goForword() {
		driver.navigate().forward();
		browserLooger.info("Successfully navigated to next page");
	}

	public void refresh() {
		driver.navigate().refresh();
		browserLooger.info("Page refreshed");
	}

	public Set<String> getWindowHandels() {
		return driver.getWindowHandles();
	}

	public void switchToWindow(int index) {

		LinkedList<String> windowsID = new LinkedList<String>(getWindowHandels());

		if (index < 0 || index > windowsID.size()) {
			throw new IllegalArgumentException("Invalid Window Id" + index);
		} else {
			driver.switchTo().window(windowsID.get(index));
			browserLooger.info(index + "Window selected");
		}
	}

	public void switchToParentWindow() {

		LinkedList<String> windowsID = new LinkedList<String>(getWindowHandels());

		driver.switchTo().window(windowsID.get(0));
		browserLooger.info("Switched to Parent Window");
	}

	public void switchToParentWithChildClose() {

		LinkedList<String> windowsID = new LinkedList<String>(getWindowHandels());
		for (int i = 1; i < windowsID.size(); i++) {
			driver.switchTo().window(windowsID.get(i));
			driver.close();
		}
		switchToParentWindow();
	}
	
	public void switchToFrame(String nameOrId){
		driver.switchTo().frame(nameOrId);
		browserLooger.info("Switched to frame"+nameOrId);
	}
}
