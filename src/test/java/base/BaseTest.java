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
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	/*public WebDriver driver;
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
			
			if (broswer.equalsIgnoreCase("chrome")) {
			    WebDriverManager.chromedriver().setup(); // setup driver

			    // Create ChromeOptions
			    ChromeOptions options = new ChromeOptions();

			    // Run headless if config says so
			    if (config.isHeadless()) {
			        options.addArguments("--headless=new");
			        options.addArguments("--no-sandbox");
			        options.addArguments("--disable-dev-shm-usage");
			    }

			    driver = new ChromeDriver(options);
			}
			
			
			
			
		}
		
		driver.manage().window().maximize();
		
		
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
*/
	
	
	
    public WebDriver driver;
    ConfigReader config;
    public static ExtentReports extent;
    public ExtentTest test;

    public static Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
        String browser = config.getValue("browser"); // fixed typo

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Run headless if config says so
            if (config.isHeadless()) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.get(config.getValue("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
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

	