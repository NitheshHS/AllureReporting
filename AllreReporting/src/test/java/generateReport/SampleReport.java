package generateReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
@Listeners(generateReport.ITestListenerImp.class)
public class SampleReport extends BaseClass {
	WebDriver driver;
	@Parameters(value = {"BrowserName"})
	@BeforeClass
	public void setUp(String browser) {
		BaseClass b=new BaseClass();
		driver=b.getInstanceOfDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
	}
	@Test(priority = 0)
	@Severity(SeverityLevel.BLOCKER)
	@Epic("VT_01")
	@Description("Login to the application as valid user")
	@Step("Login to vTiger app")
	public void loginTest() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager",Keys.ENTER);
	}
	
	@Test(priority = 1)
	@Severity(SeverityLevel.BLOCKER)
	@Epic("VT_01")
	@Description("create a organization")
	@Step("Creating the organization by entering mandatory fields")
	public void createOrganization() {
		System.out.println("created organization");
		Assert.assertTrue(false);
	}
	@Test(priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	@Epic("VT_01")
	@Description("Logout to the application after performing all the steps")
	@Step("logout to vTiger app")
	public void logoutTest() {
		throw new SkipException("logoutTest is skipped");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
