package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;

	@BeforeMethod

	public void SetUpDriver() {
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	@BeforeTest
	public void SetUpExcel() {
		
	}
	@AfterTest
	public void CloseExcel() {
		
	} 
}