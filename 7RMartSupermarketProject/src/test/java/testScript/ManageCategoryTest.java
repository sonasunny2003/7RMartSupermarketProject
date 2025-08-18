package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends BaseClass {

	HomePage homepage;
	ManageCategoryPage category;

	@Test(description = "Verify the user is able to find the added category through search")
	public void searchingTheAddedCategory() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).selectCheckBox();
		homepage = login.clickSignInButton();

		category=homepage.clickOnManageCategoryTab();

		category.clickSearchButton().enterTextInSearchCategory().clickSearchCategoryButton();

		String expected = Constants.SEARCHCATEGORYVALUE;
		String actual = category.checkTitle();
		Assert.assertEquals(actual, expected, Messages.CATEGORYSEARCHERROR);
	}
}
