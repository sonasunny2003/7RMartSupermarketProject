package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constants;
import constant.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends BaseClass {

	HomePage home;
	AdminUsersPage admin;

	@Test(description = "Verify the user is able to add new admin users")
	public void verifyWhetherTheUserIsAbleToAddNewAdminUsers() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		home = login.clickSignInButton();

		admin = home.clickOnAdminUsersTab();
		admin.clickOnNewButton();

		FakerUtility fakerutility = new FakerUtility();

		String newUserName = fakerutility.createRandomUserName();
		String newPassword = fakerutility.createRandomPassword();

		admin.enterNewUserNameOnUserNameField(newUserName).enterNewPasswordOnPasswordField(newPassword).selectUserType()
				.clickOnSaveButton();

		boolean greenalert = admin.checkAlertMessage();
		Assert.assertTrue(greenalert, Messages.USERADDMSG);
	}

	@Test(description = "Verify the user is able to find the added admin users through search")
	public void verifyTheUserCanSearchAddedAdminUsers() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		home = login.clickSignInButton();

		admin = home.clickOnAdminUsersTab();

		admin.clickOnSearchButton().enterUserNameInSearchField().selectUserTypeInSearchField()
				.clickOnSearchAdminUserButton();

		String actual = Constants.TEXTONSEARCHTAB;
		String expected = admin.getTextFromThePage();
		Assert.assertEquals(actual, expected, Messages.USERSEARCHMSG);
	}

	@Test(description = "Verify that the user is able to reset the page by clicking the Reset button")
	public void verifyResetOptionOnAdminUsersPage() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		home = login.clickSignInButton();

		admin = home.clickOnAdminUsersTab();

		admin.clickOnResetButton();

		boolean headingdisplayed = admin.checkTitle();
		Assert.assertTrue(headingdisplayed, Messages.USERRESETMSG);
	}
}
