package tests;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddEmployeePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.JsonReader;
import utilities.Screenshot;

public class AddEmployeeTest extends BaseTest {
	
	String empID;
	
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
        pim.clickPim();
        pim.clickAddEmployee();

        // 🧾 Step 3: Add employee
        log.info("Entering employee details");
        
         empID = String.valueOf(System.currentTimeMillis()).substring(7);

        pim.eneterEmployeeDetails(fname, lname, empID);

        pim.clickSave();        
        
        Screenshot.attachScreenshotToReport(driver, "AddedEmployee_" + fname, test);

        
       Assert.assertTrue(pim.isEmployeeAdded(), "Employee not added!");

        log.info("Employee added successfully: " + fname + " " + lname);
        test.pass("Employee added successfully: " + fname + " " + lname);

        log.info("===== Test Finished =====");
    }
    
   @Test(dataProvider = "empdata" ,dependsOnMethods="addEmployeeTest")
	public void searchEmployeeTest(String Fname, String Lname)
	{
		test = extent.createTest("Search Employee:"+Fname);
		log.info("===== Starting search Test =====");
		
	    AddEmployeePage pim = new AddEmployeePage(driver);

		pim.clickPim();
		pim.searchEmployee(Fname, Lname);
		
		// 🔹 Step 3: Validate result
		
		//Assert.assertTrue(pim.isEmployeeFoundById(empID), "Employee not found with Id" + empID);	           
	    
		Assert.assertTrue(
			    pim.isSearchResultDisplayed(),
			    "Search result not displayed"
			);
	    log.info("EmployeeId found successfully: " + empID);

	    test.pass("Search successful for: " + Fname + " " + Lname);
		
		
	}
    
    @Test(dependsOnMethods="addEmployeeTest")  
   public void updateEmployeeTest()
   {
	   
		test = extent.createTest("Update Employee Test:");
		log.info("===== Starting Update Test =====");
		
	    AddEmployeePage pim = new AddEmployeePage(driver);

		pim.clickPim();
         
		String oldFname ="Alice";
		String oldLname ="Brown";
		pim.searchEmployee(oldFname, oldLname);
		
		pim.clickEditIcon();
		
        String updatedName ="johnny";

pim.updateEmployeeName(updatedName);


	   Assert.assertTrue(pim.isEmployeeUpdated(updatedName),"Employee not updated");
	   
	   log.info("Employee updated Successfully");

	    test.pass("Employee updated Successfully");
	   
	   
	   
	   
	   
	   
   }
    
    
    @Test(dependsOnMethods = "updateEmployeeTest")
    public void deleteEmployeeTest()
    {
        test = extent.createTest("Delete Employee Test");

        log.info("===== Starting Delete Test =====");

        AddEmployeePage pim = new AddEmployeePage(driver);

        pim.clickPim();

        pim.searchEmployee("Johnny", "Brown");

        pim.deleteEmployee();

        Assert.assertTrue(
            pim.isEmployeeDeleted(),
            "Employee not deleted"
        );

        log.info("Employee deleted successfully");

        test.pass("Employee deleted successfully");
    }
	
}