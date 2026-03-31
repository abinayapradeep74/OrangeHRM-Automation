package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

	
	WebDriver driver;
	WebDriverWait wait;

	
	  By PimMenu = By.xpath("//span[text()='PIM']"); 
	  By addemployee = By.xpath("//a[normalize-space(text())='Add Employee']"); 
	  By FirstName = By.name("firstName");
	  By LastName = By.xpath("//input[@name='lastName']");
	  
	  By SaveBtn = By.xpath("//button[@type='submit']");
	  By SuccessMsg  = By.xpath("//p[contains(text(),'Successfully Added')]");

	  
	  //Constructor
	 
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	public void ClickPim()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(PimMenu)).click();
		
	}
	
	
	public void ClickAddEmployee()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(addemployee)).click();
	}
	
	public void EneterEmployeeDetails(String Fname, String Lname)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(Fname);
		driver.findElement(LastName).sendKeys(Lname);
	}
	
public void ClickSave()
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(SaveBtn)).click();
}
	


public boolean isEmployeeAdded() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    	try {
            wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
