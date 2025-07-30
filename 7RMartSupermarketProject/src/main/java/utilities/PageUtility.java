package utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownByIndex(WebElement element, int index) {

		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}

	public void selectDropdownByText(WebElement element, String text) {

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

	public void selectCheckbox(WebElement checkbox) {

		if (!checkbox.isSelected()) {

			checkbox.click();
		}
	}

	public void selectRadioButton(WebElement radioButton) {

		if (!radioButton.isSelected()) {

			radioButton.click();
		}
	}
	public void clickElementByJS(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollUp(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500)"); // scrolls up by 500 pixels
	}

	public void scrollDown(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)"); // scrolls down by 500 pixels
	}

	public void rightClick(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {

		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public void hoverOverElement(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

}
