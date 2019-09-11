package helper.dropDownHelper;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {

	private WebDriver driver;
	private static Logger dropDownHelper = Logger.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		dropDownHelper.debug("Dropdown Helper: " + this.driver.hashCode());
	}

	public void selectUsingVisibleValue(WebElement ele, String valueToBeSelected) {

		Select sel = new Select(ele);
		sel.deselectByVisibleText(valueToBeSelected);
		dropDownHelper.info("Sucessfully Selected drop-down value" + valueToBeSelected);
	}

	public void SelectUsingIndex(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
		String selectedValue = sel.getFirstSelectedOption().getText();
		dropDownHelper.info("Selected value from dropdown is: " + selectedValue + " Index is " + index);

	}

	public String getSelectedValue(WebElement ele) {
		Select sel = new Select(ele);
		String selectedValue = sel.getFirstSelectedOption().getText();
		dropDownHelper.info("Selected value from dropdown is: " + selectedValue);
		return selectedValue;

	}

	public List<String> getAllSelectedValue(WebElement ele) {
		Select sel = new Select(ele);
		List<WebElement> listOfValues = sel.getAllSelectedOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement element : listOfValues) {
			dropDownHelper.info(element.getText());
			valueList.add(element.getText());
		}
		return valueList;
	}

}
