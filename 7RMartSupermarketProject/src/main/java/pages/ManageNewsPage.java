package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsinputfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement searchtitlefield;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchtitlebutton;
	@FindBy(xpath = "//td[text()='New Software Launched']")
	WebElement list;

	public ManageNewsPage clickOnNewButton() {

		newbutton.click();
		return this;
	}

	public ManageNewsPage enterTextInNewsField() {

		newsinputfield.sendKeys(Constants.NEWSTEXT);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {

		savebutton.click();
		return this;
	}

	public boolean checkAlertMessage() {

		return alertmessage.isDisplayed();
	}

	public ManageNewsPage clickOnSearchButton() {

		searchbutton.click();
		return this;
	}

	public ManageNewsPage enterNewsTitle() {

		searchtitlefield.sendKeys(Constants.NEWSTEXT);
		return this;
	}

	public ManageNewsPage clickOnSearchTitleButton() {

		searchtitlebutton.click();
		return this;
	}

	public String checkTitle() {

		return list.getText();
	}
}
