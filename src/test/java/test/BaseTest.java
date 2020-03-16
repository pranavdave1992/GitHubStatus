package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\util\\chromedriver.exe");
		driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		// Opening the browser
		driver.get("https://www.githubstatus.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
	}
	
	@AfterSuite
	public void tearoff() {
		//driver.quit();
	}

}
