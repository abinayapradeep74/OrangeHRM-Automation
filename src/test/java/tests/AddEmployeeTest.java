package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddEmployeePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.JsonReader;

public class AddEmployeeTest extends BaseTest {
	







	@BeforeMethod
	public void login() {
	    ConfigReader config = new ConfigReader();
	    
	    driver.get(config.getValue("url"));  // open OrangeHRM
	    
	    
	    //login with valid login details

	    LoginPage lp = new LoginPage(driver);
	    lp.enterusername(config.getValue("username"));  
	    lp.enterpassword(config.getValue("password"));   
	    lp.clicklogin();                                 

	    //  validation & logger
	    Assert.assertTrue(lp.isloginsuccesfull(), "Login failed!");

	}
	
	@DataProvider(name = "empdata")
	
	  public Object[][] getData() {
	  
	 
	  
		String path = System.getProperty("user.dir") + "/src/test/resources/AddEmployee.json";

	    JSONArray jsonArray = JsonReader.getJsonData(path);

	    Object[][] data = new Object[jsonArray.length()][2];

	    for (int i = 0; i < jsonArray.length(); i++) {
	        data[i][0] = jsonArray.getJSONObject(i).getString("Fname");
	        data[i][1] = jsonArray.getJSONObject(i).getString("Lname");
	    }

	    return data;
	  
	  
	  }
	 
	
	
	
	
	
	
    @Test(dataProvider = "empdata")
    public void addEmployeeTest(String fname, String lname) {
    	
    	

    	
    	

        test = extent.createTest("Add Employee Test: " + fname);

        log.info("===== Starting Add Employee Test =====");
        
        

        // 📂 Step 2: Navigate to PIM
        AddEmployeePage pim = new AddEmployeePage(driver);
        pim.ClickPim();
        pim.ClickAddEmployee();

        // 🧾 Step 3: Add employee
        log.info("Entering employee details");
        pim.EneterEmployeeDetails(fname, lname);

        pim.ClickSave();
        
        //Assert.assertTrue(pim.isEmployeeAdded(fname,lname), "Employee not added!");        
        
        
        Assert.assertTrue(pim.isEmployeeAdded(), "Employee not added!");

        



        log.info("Employee added successfully: " + fname + " " + lname);
        test.pass("Employee added successfully: " + fname + " " + lname);

        log.info("===== Test Finished =====");
    }
	
	
}
