package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin;                                             //It’s a dropdown toggle element that looks like a link but works like a button.
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;
	
	public void clickOnAdmin()
	{
		admin.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
}
