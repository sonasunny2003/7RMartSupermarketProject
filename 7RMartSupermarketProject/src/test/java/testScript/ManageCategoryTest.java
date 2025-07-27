package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends BaseClass {

	@Test(description="Verify the user is able to add a new category to the category page")
	public void addingNewCategoryToTheCategoryPage() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		ManageCategoryPage category=new ManageCategoryPage(driver);
		
		category.clickOnManageCategoryTab();
		category.clickNewButton();
		category.enterTextInCategory();
		category.selectFile();
		category.clickSaveButton();
		
		/*String expected="List Categories";
		String actual=category.getTitle();
		Assert.assertEquals(actual, expected," The user was unable to add the new category");*/
		
	}
	
	@Test(description="Verify the user is able to find the added category through search")
	public void searchingTheAddedCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		ManageCategoryPage category=new ManageCategoryPage(driver);
		category.clickOnManageCategoryTab();
		category.clickSearchButton();
		category.enterTextInSearchCategory();
		category.clickSearchCategoryButton();
		
		String expected="Dress";
		String actual=category.checkTitle();
		Assert.assertEquals(actual, expected,"The user was unable to find the category through search");
	}
}
