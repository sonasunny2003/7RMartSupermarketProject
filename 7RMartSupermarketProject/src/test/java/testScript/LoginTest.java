package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass {

	HomePage homepage;

	@Test(retryAnalyzer = retry.Retry.class, priority = 1, description = "Verifying user login with valid credentials")
	public void verifyLoginWithValidCredentials() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		homepage = login.clickSignInButton();

		boolean dashboarddisplayed = login.isDashBoardTileDisplayed();
		Assert.assertTrue(dashboarddisplayed, Messages.VALIDCREDENTIALSERROR);

		/*
		 * boolean alertdisplayed=login.isAlertDisplayed();
		 * Assert.assertFalse(alertdisplayed,
		 * "User was unable to login with valid credentials");
		 */
	}

	@Test(priority = 2, description = "Verifying user login with valid username and invalid password", groups = {
			"smoke" })
	public void verifyLoginWithValidUserNameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox()
				.clickSignInButton();

		String expected = Constants.LOGINASSERTIONVALUE;
		String actual = login.getTextFromTitle();

		Assert.assertEquals(actual, expected, Messages.INVALIDPASSWORDERROR);
	}

	@Test(priority = 3, description = "Verifying user login with invalid username and valid password", groups = {
			"smoke" })
	public void verifyLoginWithInvalidUserNameAndValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox()
				.clickSignInButton();

		String expected = Constants.LOGINASSERTIONVALUE;
		String actual = login.getTextFromTitle();

		Assert.assertEquals(actual, expected, Messages.INVALIDUSERNAMEERROR);
	}

	@Test(priority = 4, description = "Verifying user login with ivalid credentials", dataProvider = "loginProvider")
	public void verifyLoginWithInvalidCredentials(String username, String password) throws IOException {

		/*
		 * String username = ExcelUtility.getStringData(3, 0, "LoginPage"); String
		 * password = ExcelUtility.getStringData(3, 1, "LoginPage");
		 */

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox()
				.clickSignInButton();

		String expected = Constants.LOGINASSERTIONVALUE;
		String actual = login.getTextFromTitle();

		Assert.assertEquals(actual, expected, Messages.INVALIDCREDENTIALSERROR);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
