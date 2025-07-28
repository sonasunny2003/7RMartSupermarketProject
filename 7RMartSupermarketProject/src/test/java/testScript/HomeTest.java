package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends BaseClass{

	@Test(description="Verify the user can logout successfully")
	public void verifyUserCanLogoutSuccessfully() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		HomePage home=new HomePage(driver);
		home.clickOnAdmin();
		home.clickOnLogout();
		
		boolean headingisdisplayed=home.checkTitle();
		Assert.assertTrue(headingisdisplayed,Messages.LOGOUTERROR);
		
	}
	
}
