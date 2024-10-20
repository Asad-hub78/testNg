package TestCases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;


@Listeners(Listener.class)
public class LoginTest extends BaseClass {
	@Test(groups= {"sanity"}, description="Login Failure")
	public void TC01_LoginFailureTest() {
		
		LoginPage LP = new LoginPage(GetDriver());
		LP.LoginFunction("abc@xyz", "ABC@1234");
		LP.ValidateErrorMsg("The email or password you have entered is invalid");
			
	}
	@Test(groups= {"sanity"}, description = "Login Success")
public void TC02_LoginSuccessTest() {
	LoginPage LP = new LoginPage(GetDriver());
	LP.LoginFunction("abc@xyz", "ABC@1234");
}
	@Test
	@Parameters({"param1","param2"})
public void TC03_LoginSuccessTest(String Uname, String Pwd) {
		LoginPage LP = new LoginPage(GetDriver());
		LP.LoginFunction(Uname, Pwd);
}
Map<String, String> testdata = new HashMap<String, String>();
	
	
	@Test(dataProvider="dp")
	public void TC04_LoginSuccessTest(String key) {
		
		LoginPage lp = new LoginPage(GetDriver());
		lp.LoginFunction(key, testdata.get(key));
		
	}
	
	
	@DataProvider(name = "dp")
	public Iterator<String> method1() {
		
		testdata.put("aaa@xyz.com", "Abc@1234");
		testdata.put("bbb@xyz.com", "Abc@1234");
		testdata.put("ccc@xyz.com", "Abc@1234");
		testdata.put("ddd@xyz.com", "Abc@1234");
		testdata.put("eee@xyz.com", "Abc@1234");
		return testdata.keySet().iterator();
		
	}

	}


