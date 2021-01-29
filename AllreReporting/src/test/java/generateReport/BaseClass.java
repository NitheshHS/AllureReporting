package generateReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	public static ThreadLocal<WebDriver> tDriver=new ThreadLocal<WebDriver>();
	
	public WebDriver getInstanceOfDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		tDriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tDriver.get();
	}

}
