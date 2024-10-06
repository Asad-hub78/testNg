package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;
import junit.framework.Assert;

public class LoginPage {
	WebDriver driver = BaseClass.driver;
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	@FindBy(name = "user_login")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id = "remember-me")
	WebElement RememberMe;
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	@FindBy(className = "error_msg")
	WebElement Error;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void LoginFunction(String UserNameVal, String PwdVal) {

		LoginLink.click();

		UserName.sendKeys(UserNameVal);

		Password.sendKeys(PwdVal);

		RememberMe.click();
		LoginBtn.click();

	}
	public void ValidateErrorMsg(String ExpMsg) {
		String ActMsg = Error.getText();
		Assert.assertEquals(ExpMsg, ActMsg);
	}

}
