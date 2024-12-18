package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;
	private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public void SetDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}
	
	public WebDriver GetDriver() {

		return threadLocalDriver.get();

	}


	@BeforeMethod(alwaysRun = true)

	public void SetUpDriver() throws MalformedURLException {
		
		String browser = System.getProperty("Browser");

ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox"); 
			options.addArguments("--disable-dev-shm-using") ;
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--headless") ;
options.addArguments("--ignore-ssl-errors=yes");
options.addArguments("--ignore-certificate-errors");
			
			//String browser = "chrome";
			
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("remote-chrome")) {
				
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setPlatform(Platform.WIN10);
				cap.setBrowserName("chrome");

				URL hub = new URL("http://localhost:4444/");
				driver = new RemoteWebDriver(hub, cap);
				
			}
			else {
				driver = new ChromeDriver(options);
			}
			SetDriver(driver);
		
			driver.get("https://simplilearn.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
	@AfterMethod(alwaysRun=true)
	public void TearDown() {
		
		GetDriver().quit();
	}


	
	@BeforeTest (alwaysRun = true)
	public void SetUpExcel() {
		
	}
	@AfterTest (alwaysRun= true)
	public void CloseExcel() {
		
	} 
}