package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;
import utilities.ExtentManager;

public class BaseTest {
	
	public WebDriver driver;
	ConfigReader config;
	public static ExtentReports extent;
    public ExtentTest test;
	
    public static Logger log = LogManager.getLogger(BaseTest.class);

    
    
    @BeforeSuite
    public void setupReport()
    {
    	extent = ExtentManager.getInstance();
    }
	
	@BeforeMethod
	public void set()
	
	{
		config = new ConfigReader();
		String broswer = config.getValue("browser");
		
		if(broswer.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
	//	driver.get("https://opensource-demo.orangehrmlive.com");
		
		
		driver.get(config.getValue("url"));
	}
	
	
	@AfterMethod
	public void teardown()
	{
		if(driver!=null) {
		driver.quit();
	
		}
	}
		@AfterSuite
	    public void flushReport() {
	        if (extent != null) {
	            extent.flush();
	        }
		
		

	}

}
