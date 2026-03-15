package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By username = By.name("username");
	By password = By.name("password");
	
	By loginBtn = By.xpath("//button[@type='submit']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void Login(String user, String pass)
	{
	System.out.println("waiting for username ");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
		System.out.println("Entering username");
		
		System.out.println("waiting for password");
		System.out.println("Entering password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		//driver.findElement(username).sendKeys(user);
		//driver.findElement(password).sendKeys(pass);
		//driver.findElement(loginBtn).click();
		
	}
	

}
