package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends BaseClass{

	@Test
	public void verifyWhetherTheUserIsAbleToAddNewAdminUsers() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		AdminUsersPage adminuser=new AdminUsersPage(driver);
		adminuser.clickOnAdminUsersTab();
		adminuser.clickOnNewButton();
		
		FakerUtility fakerutility=new FakerUtility();
		
		String newUserName=fakerutility.createRandomUserName();
		String newPassword=fakerutility.createRandomPassword();
		
		adminuser.enterNewUserNameOnUserNameField(newUserName);
		adminuser.enterNewPasswordOnPasswordField(newPassword);
		
		adminuser.selectUserType();
		adminuser.clickOnSaveButton();
		
		boolean greenalert=adminuser.checkAlertMessage();
		Assert.assertTrue(greenalert,"The user was unable to add new admin users successfully");
	}
	
	@Test
	public void verifyTheUserCanSearchAddedAdminUsers() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.selectCheckBox();
		login.clickSignInButton();
		
		AdminUsersPage adminuser=new AdminUsersPage(driver);
		adminuser.clickOnAdminUsersTab();
		adminuser.clickOnSearchButton();
		adminuser.enterUserNameInSearchField();
		adminuser.selectUserTypeInSearchField();
		adminuser.clickOnSearchAdminUserButton();
		
		String actual="sonasunny";
		String expected=adminuser.getTextFromThePage();
		Assert.assertEquals(actual, expected,"The user was unable to find the added admin users using the search");
	}
}
