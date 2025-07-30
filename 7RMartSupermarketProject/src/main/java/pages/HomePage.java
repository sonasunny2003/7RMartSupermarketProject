package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	public WebDriver driver;

	PageUtility page = new PageUtility();

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin; // It’s a dropdown toggle element that looks like a link but works like a
						// button.
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement heading;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement managecategorytab;

	@FindBy(xpath = "//p[text()='Manage News']//ancestor::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement managenewstab;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminuser;

	public HomePage clickOnAdmin() {

		admin.click();
		return this;
	}

	public LoginPage clickOnLogout() {

		logout.click();
		return new LoginPage(driver);
	}

	public boolean checkTitle() {

		return heading.isDisplayed();
	}

	public ManageCategoryPage clickOnManageCategoryTab() {

		managecategorytab.click();
		return new ManageCategoryPage(driver);

	}

	public ManageNewsPage clickOnManageNewsTab() {

		managenewstab.click();
		return new ManageNewsPage(driver);
	}

	public AdminUsersPage clickOnAdminUsersTab() {

		page.clickElementByJS(driver, adminuser);
		return new AdminUsersPage(driver);
	}

}
