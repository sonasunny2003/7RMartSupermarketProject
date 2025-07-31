package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constant.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;

	PageUtility page = new PageUtility();
	WaitUtility wait=new WaitUtility();

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement username1;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement usertype1;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchadminuser;
	@FindBy(xpath = "//h4[text()='Search Admin Users']")
	WebElement checktext;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbutton;
	@FindBy(xpath = "//h1[text()='Admin Users']")
	WebElement heading;

	public AdminUsersPage clickOnNewButton() {

		wait.waitUntilElementToBeClickable(driver, newbutton);
		page.clickElementByJS(driver, newbutton);
		return this;
	}

	public AdminUsersPage enterNewUserNameOnUserNameField(String newUserName) {

		username.sendKeys(newUserName);
		return this;
	}

	public AdminUsersPage enterNewPasswordOnPasswordField(String newPassword) {

		password.sendKeys(newPassword);
		return this;
	}

	public AdminUsersPage selectUserType() {
		/*
		 * Select s=new Select(usertype); s.selectByIndex(2);
		 */
		page.selectDropdownByIndex(usertype, 2);
		return this;
	}

	public AdminUsersPage clickOnSaveButton() {

		savebutton.click();
		return this;
	}

	public boolean checkAlertMessage() {

		return alert.isDisplayed();
	}

	public AdminUsersPage clickOnSearchButton() {

		searchbutton.click();
		return this;
	}

	public AdminUsersPage enterUserNameInSearchField() {

		username1.sendKeys(Constants.ADDEDUSERNAME);
		return this;
	}

	public AdminUsersPage selectUserTypeInSearchField() {
		/*
		 * Select s=new Select(usertype1);
		 * s.selectByValue(Constants.ADMINUSERDROPDOWNVALUE);
		 */
		page.selectDropdownWithValue(usertype1, Constants.ADMINUSERDROPDOWNVALUE);
		return this;
	}

	public AdminUsersPage clickOnSearchAdminUserButton() {

		searchadminuser.click();
		return this;
	}

	public String getTextFromThePage() {

		return checktext.getText();
	}

	public AdminUsersPage clickOnResetButton() {

		resetbutton.click();
		return this;
	}

	public boolean checkTitle() {

		return heading.isDisplayed();
	}
}
