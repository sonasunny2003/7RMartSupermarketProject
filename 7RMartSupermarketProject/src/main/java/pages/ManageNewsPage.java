package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Manage News']//ancestor::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement managenewstab;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")WebElement newsinputfield;
	@FindBy(xpath="//button[@type='submit']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmessage;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchbutton;
	@FindBy(xpath="//input[@placeholder='Title']")WebElement searchtitlefield;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement searchtitlebutton;
	@FindBy(xpath="//td[text()='New Software Launched']")WebElement list;
	
	
	public void clickOnManageNewsTab()
	{
		managenewstab.click();
	}
	
	public void clickOnNewButton()
	{
		newbutton.click();
	}
	
	public void enterTextInNewsField()
	{
		newsinputfield.sendKeys("New Software Launched");
	}
	
	public void clickOnSaveButton()
	{
		savebutton.click();
	}
	
	public boolean checkAlertMessage()
	{
		return alertmessage.isDisplayed();
	}
	
	public void clickOnSearchButton()
	{
		searchbutton.click();
	}
	
	public void enterNewsTitle()
	{
		searchtitlefield.sendKeys("New Software Launched");
	}
	
	public void clickOnSearchTitleButton()
	{
		searchtitlebutton.click();
	}
	
	public String checkTitle()
	{
		return list.getText();
	}
}
