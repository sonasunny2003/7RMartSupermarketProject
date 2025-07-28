package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Messages;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass{

	@Test(description="Verify the user is able to add new news to the news page")
	public void verifyWhetherTheUserIsAbleToaddNewNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnManageNewsTab();
		news.clickOnNewButton();
		news.enterTextInNewsField();
		news.clickOnSaveButton();
		
		boolean greenalert=news.checkAlertMessage();
		Assert.assertTrue(greenalert,Messages.NEWSADDERROR);
	}
	
	@Test(description="Verify the user is able to find the added news through search")
	public void verifyUserIsAbleTosearchAddedNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		ManageNewsPage news=new ManageNewsPage(driver);
		news.clickOnManageNewsTab();
		news.clickOnSearchButton();
		news.enterNewsTitle();
		news.clickOnSearchTitleButton();
		
		String actual="New Software Launched";
		String expected=news.checkTitle();
		Assert.assertEquals(actual, expected,Messages.NEWSSEARCHERROR);
	}
	
	
}
