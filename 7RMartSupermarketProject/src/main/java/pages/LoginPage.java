package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {

	public WebDriver driver;

	PageUtility page = new PageUtility();

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordfield;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard; // assert-true
	@FindBy(xpath = "//i[@class='icon fas fa-ban']")
	WebElement alert; // assert-false
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement pagetitle; // asert-equals

	public LoginPage enterUserNameOnUserNameField(String username) {

		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {

		passwordfield.sendKeys(password);
		return this;
	}

	public LoginPage selectCheckBox() {

		page.clickElementByJS(driver, checkbox);
		return this;
	}

	public HomePage clickSignInButton() {

		page.clickElementByJS(driver, signinbutton);
		return new HomePage(driver);
	}

	public boolean isDashBoardTileDisplayed() {

		return dashboard.isDisplayed();
	}

	/*
	 * public boolean isAlertDisplayed() { return alert.isDisplayed(); }
	 */

	public String getTextFromTitle() {

		return pagetitle.getText();
	}

}
