package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest extends BaseTest {
	
	
	@DataProvider(name = "loginData")
    public Object[][] getData() {
        
        String path = System.getProperty("user.dir") + "/Logindata.xlsx";

        return ExcelUtils.getTestData(path, "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void verifyLogin(String username, String password, String expectedResult) {
    	
    	test = extent.createTest("Login Test for user: " + username);
    	
        log.info("===== Starting Test for user: " + username + " =====");
        log.info("Opening login page");
        test.info("Opening login page");
        
        LoginPage lp = new LoginPage(driver);
        	
        log.info("Entering username: " + username);
        test.info("Entering username: " + username);
        lp.enterusername(username);
        
        log.info("Entering password");
        test.info("Entering password: " + password);
        lp.enterpassword(password);
        
        
        log.info("Clicking login button");
        test.info("Clicking login button");
        lp.clicklogin();

        log.info("Validating login result");
        boolean actualResult = lp.isloginsuccesfull();

        if (expectedResult.equalsIgnoreCase("pass")) {
            Assert.assertTrue(actualResult, "Expected login to pass");
            log.info("Login successful");
            test.pass("Login successful");
         
        } else {
            Assert.assertFalse(actualResult, "Expected login to fail");
            log.info("Login failed as expected");
            test.pass("Login failed as expected");
        }
        
        log.info("===== Test Finished =====");

    }		
		
		
}
	
	
	
