package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminuser;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton;
	@FindBy(xpath="//input[@id='un']")WebElement username1;
	@FindBy(xpath="//select[@id='ut']")WebElement usertype1;
	@FindBy(xpath="//button[@name='Search']")WebElement searchadminuser;
	@FindBy(xpath="//td[text()='sonasunny']")WebElement text;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement resetbutton;
	@FindBy(xpath="//h1[text()='Admin Users']")WebElement heading;
	
	
	public void clickOnAdminUsersTab()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", adminuser);
		
	}
	
	public void clickOnNewButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", newbutton);
		
	}
	
	public void enterNewUserNameOnUserNameField(String newUserName)
	{
		username.sendKeys(newUserName);
	}
	
	public void enterNewPasswordOnPasswordField(String newPassword)
	{
		password.sendKeys(newPassword);
	}
	
	public void selectUserType()
	{
		Select s=new Select(usertype);
		s.selectByIndex(2);
	}
	
	public void clickOnSaveButton()
	{
		savebutton.click();
	}
	
	public boolean checkAlertMessage()
	{
		return alert.isDisplayed();
	}
	
	public void clickOnSearchButton()
	{
		searchbutton.click();
	}
	
	public void enterUserNameInSearchField()
	{
		username1.sendKeys("sonasunny");
	}
	
	public void selectUserTypeInSearchField()
	{
		Select s=new Select(usertype1);
		s.selectByValue("admin");
	}
	
	public void clickOnSearchAdminUserButton()
	{
		searchadminuser.click();
	}
	
	public String getTextFromThePage()
	{
		return text.getText();
	}
	
	public void clickOnResetButton()
	{
		resetbutton.click();
	}
	
	public boolean checkTitle()
	{
		return heading.isDisplayed();
	}
}
