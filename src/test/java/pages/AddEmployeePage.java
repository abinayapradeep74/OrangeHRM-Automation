package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
	
	WebDriver driver;
	
By PimMenu = By.xpath("//span[text()='PIM']");
By addemployee = By.xpath("//a[text()='Add Employee ']");
By FirstName = By.name("firstName");
By LastName = By.name("name=\"lastName\"");

By SaveBtn = By.xpath("//button[@type='submit']");



//Constructor

public AddEmployeePage(WebDriver driver) {
	this .driver = driver;
}

	public void addEmployee(String fname, String lname)
	{
		
		driver.findElement(PimMenu).click();
		driver.findElement(addemployee).click();
		driver.findElement(FirstName).sendKeys(fname);
		driver.findElement(LastName).sendKeys(lname);
		driver.findElement(SaveBtn).click();
		
	}



	

}
