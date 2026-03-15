package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void VerifyLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.Login("Admin", "admin123");
	}

}
