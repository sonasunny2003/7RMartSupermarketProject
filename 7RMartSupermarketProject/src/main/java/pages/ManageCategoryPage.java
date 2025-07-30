package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageCategoryPage {

	public WebDriver driver;

	PageUtility page = new PageUtility();

	public ManageCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchCategoryField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchcategorybutton;
	@FindBy(xpath = "//td[text()='Dress']")
	WebElement list;

	public ManageCategoryPage clickSearchButton() {

		searchbutton.click();
		return this;
	}

	public ManageCategoryPage enterTextInSearchCategory() {

		searchCategoryField.sendKeys(Constants.SEARCHCATEGORYVALUE);
		return this;
	}

	public ManageCategoryPage clickSearchCategoryButton() {

		page.clickElementByJS(driver, searchcategorybutton);
		return this;
	}

	public String checkTitle() {

		return list.getText();
	}
}
