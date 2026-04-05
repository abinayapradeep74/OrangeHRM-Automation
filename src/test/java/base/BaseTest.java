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

         // Test commit to trigger GitHub Actions            
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
            

            driver = new ChromeDriver(options);
        }

       // driver.manage().window().maximize();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
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

	