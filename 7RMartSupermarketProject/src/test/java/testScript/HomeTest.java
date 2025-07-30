package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends BaseClass {

	HomePage homepage;

	@Test(description = "Verify the user can logout successfully")
	public void verifyUserCanLogoutSuccessfully() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		homepage = login.clickSignInButton();

		homepage.clickOnAdmin();
		login = homepage.clickOnLogout();

		boolean headingisdisplayed = homepage.checkTitle();
		Assert.assertTrue(headingisdisplayed, Messages.LOGOUTERROR);

	}

}
