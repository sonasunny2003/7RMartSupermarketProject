package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {

	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyLoginWithValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		boolean dashboarddisplayed=login.isDashBoardTileDisplayed();
		Assert.assertTrue(dashboarddisplayed, "User was unable to login with valid credentials");
		
		//boolean alertdisplayed=login.isAlertDisplayed();
		//Assert.assertFalse(alertdisplayed, "User was unable to login with valid credentials");
	}
	
	@Test
	public void verifyLoginWithValidUserNameAndInvalidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		String expected="7rmart supermarket";
		String actual=login.getTextFromTitle();
		
		Assert.assertEquals(actual, expected,"User was able to login with invalid password");
	}
	
	@Test
	public void verifyLoginWithInvalidUserNameAndValidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		String expected="7rmart supermarket";
		String actual=login.getTextFromTitle();
		
		Assert.assertEquals(actual, expected,"User was able to login with invalid username");
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		String expected="7rmart supermarket";
		String actual=login.getTextFromTitle();
		
		Assert.assertEquals(actual, expected,"User was able to login with invalid credentials");
	}
}
