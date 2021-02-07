package generateReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	public static ThreadLocal<WebDriver> tDriver=new ThreadLocal<WebDriver>();
	
	public WebDriver getInstanceOfDriver(String BrowserName) {
		if(BrowserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			tDriver.set(driver);
		}
		else if(BrowserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			tDriver.set(driver);
		}
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tDriver.get();
	}

}
