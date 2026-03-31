
package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class LoginPage  {
	
    private static final Logger log = LogManager.getLogger(LoginPage.class);
	WebDriver driver;
	WebDriverWait wait;
	
	By username = By.name("username");
	By password = By.name("password");
	
	By loginBtn = By.xpath("//button[@type='submit']");
	
	By Dashboard = By.xpath("//h6[text()='Dashboard']");
	By Profileicon = By.xpath("//img[@class='oxd-userdropdown-img']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterusername(String user)
	{
        log.info("Entering username: " + user);

		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
	}
	
	public void enterpassword(String pass)
	{
		
        log.info("Entering password");

			wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
	}
	
	public void clicklogin()
	{
        log.info("Clicking login button");

		
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	}
		
	public boolean isloginsuccesfull()
	{
        log.info("Checking if login is successful");

		
		try {
			
			boolean dashboardheader = wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard)).isDisplayed();
			
			boolean Profile = wait.until(ExpectedConditions.visibilityOfElementLocated(Profileicon)).isDisplayed();
			
			
            log.info("Login success elements found");

			return dashboardheader && Profile;
			 
		}
		
		catch(Exception e)
		{
            log.error("Login validation failed: " + e.getMessage());

			return false;
		}
		
		
		
		
	}
	

}
