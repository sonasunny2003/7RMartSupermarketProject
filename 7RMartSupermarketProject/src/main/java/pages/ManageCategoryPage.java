package pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.ExcelUtility;


public class ManageCategoryPage {

	public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")WebElement managecategorytab;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")WebElement categoryfield;
	@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	@FindBy(xpath="//h1[text()='List Categories']")WebElement pagetitle;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchbutton;
	@FindBy(xpath="//input[@class='form-control']")WebElement searchCategoryField;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement searchcategorybutton;
	@FindBy(xpath="//td[text()='Dress']")WebElement list;
	
	public void clickOnManageCategoryTab()
	{
		
		managecategorytab.click();;
	}
	
	public void clickNewButton()
	{
		newbutton.click();
	}
	
	public void enterTextInCategory() throws IOException
	{
		String category1=ExcelUtility.getStringData(0, 0, "categoryName");
		categoryfield.sendKeys(category1);
	}
	
	public void selectFile()
	{
		choosefile.sendKeys(Constants.IMAGEFILE);
	}
	
	public void clickSaveButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,950)","");
		js.executeScript("arguments[0].click();", savebutton);
		
	}
	
	/*public String getTitle()
	{
		return pagetitle.getText();
	}*/
	
	public void clickSearchButton()
	{
		searchbutton.click();
	}
	
	public void enterTextInSearchCategory()
	{
		searchCategoryField.sendKeys("Dress");
	}
	
	public void clickSearchCategoryButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", searchcategorybutton);
		searchcategorybutton.click();
	}
	
	public String checkTitle()
	{
		return list.getText();
	}
}
