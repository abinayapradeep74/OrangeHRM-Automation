package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Screenshot {
	
	
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + date + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    // Add screenshot to ExtentReports
    
    public static void attachScreenshotToReport(WebDriver driver, String screenshotName, ExtentTest test)
    {
        String path = takeScreenshot(driver, screenshotName);
        try {
            test.info("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    }



