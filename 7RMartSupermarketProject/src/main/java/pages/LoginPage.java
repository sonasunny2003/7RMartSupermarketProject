package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement usernamefield;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement passwordfield;
	@FindBy(xpath="//input[@type='checkbox']")WebElement checkbox;
	@FindBy(xpath="//button[@type='submit']")WebElement signinbutton;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard; //assert-true
	@FindBy(xpath="//i[@class='icon fas fa-ban']")WebElement alert; //assert-false
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement pagetitle; //asert-equals
	
	
	public void enterUserNameOnUserNameField(String username)
	{
		usernamefield.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordField(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void selectCheckBox()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", checkbox);
	}
	
	public void clickSignInButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signinbutton);
	}
	
	public boolean isDashBoardTileDisplayed()
	{
		return dashboard.isDisplayed();
	}
	
	/*public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}*/
	
	public String getTextFromTitle()
	{
		return pagetitle.getText();
	}
	
	
}
