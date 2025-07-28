package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;

public class BaseClass {
	
	Properties prop;
	FileInputStream f;

	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserLaunch(String browser) throws Exception {
		
		prop=new Properties();
		f=new FileInputStream(Constants.CONFIGFILE);
		prop.load(f);
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("Invalid browser");
		}
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {
		
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		 driver.quit();

	} //iTestResult.getStatus() ➝ Returns an integer (e.g., 1, 2, 3)
}
