package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)

	public void SetUpDriver() {
		String browser = System.getProperty("Browser");
		if (browser.equalsIgnoreCase("fireFox")) {
			
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
			
			
		}
		
			
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		driver.close();
	}
	@BeforeTest (alwaysRun = true)
	public void SetUpExcel() {
		
	}
	@AfterTest (alwaysRun= true)
	public void CloseExcel() {
		
	} 
}