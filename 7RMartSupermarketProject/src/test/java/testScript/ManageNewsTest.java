package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends BaseClass {

	HomePage home;
	ManageNewsPage news;

	@Test(description = "Verify the user is able to add new news to the news page")
	public void verifyWhetherTheUserIsAbleToaddNewNews() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		home = login.clickSignInButton();

		news = home.clickOnManageNewsTab();

		news.clickOnNewButton().enterTextInNewsField().clickOnSaveButton();

		boolean greenalert = news.checkAlertMessage();
		Assert.assertTrue(greenalert, Messages.NEWSADDERROR);
	}

	@Test(description = "Verify the user is able to find the added news through search")
	public void verifyUserIsAbleTosearchAddedNews() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		home = login.clickSignInButton();

		news = home.clickOnManageNewsTab();

		news.clickOnSearchButton().enterNewsTitle().clickOnSearchTitleButton();

		String actual = Constants.NEWSTEXT;
		String expected = news.checkTitle();
		Assert.assertEquals(actual, expected, Messages.NEWSSEARCHERROR);
	}

}
