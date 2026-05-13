package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class AddEmployeePage {

	
	WebDriver driver;
	WebDriverWait wait;

	
	  By PimMenu = By.xpath("//span[text()='PIM']"); 
	  By addemployee = By.xpath("//a[normalize-space(text())='Add Employee']"); 
	  By FirstName = By.name("firstName");
	  By LastName = By.xpath("//input[@name='lastName']");
	  By employeeId = By.xpath("//label[text()='Employee Id']/following::input[1]");
	  By employeeIdCell1 = By.xpath("//div[@class='oxd-table-body']//div[text()='" + employeeId + "']");
	  
	  By SaveBtn = By.xpath("//button[normalize-space()='Save']");
	 // By SuccessMsg  = By.xpath("//p[contains(text(),'Successfully Added')]");
	  By Personaldetails = By.xpath("//h6[text()='Personal Details']");

	  
	  // search employee
	  
	  By EmployeeNameSearchBox = By.xpath("//label[text()='Employee Name']/following::input[@placeholder='Type for hints...'][1]");
	  By autoSuggestion = By.xpath("//div[@role='listbox']//span");
	  By SearchButton = By.xpath("//form//button[@type='submit' and normalize-space()='Search']");
	  By recordFound =
			    By.xpath("//span[contains(.,'Record') or contains(.,'No Records Found')]");
	  By employeeIdCell = By.xpath("//div[@class='oxd-table-body']//div[text()='" + employeeId + "']");
	  
	  //Edit Employee
	  By editIcon = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
	  By editFirstName = By.name("firstName");
	  By saveEditedDetails =
			    By.xpath("//button[normalize-space()='Save']");
	  
	  //Delete Employee 
	  
	  By deleteButton =    By.xpath("(//button[@type='button']//i[contains(@class,'bi-trash')])[1]");

By confirmDeleteButton =
    By.xpath("//button[normalize-space()='Yes, Delete']");
	  
	  
	  
	  //Constructor
	 
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	public void clickPim()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(PimMenu)).click();
		
	}
	
	
	public void clickAddEmployee()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(addemployee)).click();
	}
	
	public void eneterEmployeeDetails(String Fname, String Lname, String empID)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(Fname);
		driver.findElement(LastName).sendKeys(Lname);
		WebElement Idfield = driver.findElement(employeeId);
		Idfield.clear();
		Idfield.sendKeys(empID);
		
		
	}
	
public void clickSave()
{
	WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SaveBtn));
	((JavascriptExecutor) driver)
    .executeScript("arguments[0].scrollIntoView(true);",saveButton );
	
	wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	((JavascriptExecutor) driver)
    .executeScript("arguments[0].click();", saveButton);
	driver.getCurrentUrl();
}
	


public boolean isEmployeeAdded() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    	try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Personaldetails));
            return true;
        } catch (Exception e) {
        	System.out.println("Employee was not added succesfully");
            return false;
        }	
   	
}




//search employee methods

public void searchEmployee(String Fname, String Lname)
{	
	   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement searchBox = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(EmployeeNameSearchBox)
	    );

	    searchBox.clear();
	    searchBox.sendKeys(Fname + " " + Lname);
	    
	 // wait and click suggestion
	    
	 // wait for correct suggestion and click and         // Handle auto-suggestion 

	    
	    List<WebElement> suggestions = driver.findElements(autoSuggestion);
	    
	    for (WebElement suggestion : suggestions)
	    {
	        if (suggestion.getText().contains(Fname))
	        {
	            suggestion.click();
	            break;
	        }
	    }

	    WebElement searchBtn = wait.until(
	    	    ExpectedConditions.visibilityOfElementLocated(SearchButton)
	    	);

	    	((JavascriptExecutor) driver)
	    	    .executeScript("arguments[0].scrollIntoView(true);", searchBtn);


	    	((JavascriptExecutor) driver)
	    	    .executeScript("arguments[0].click();", searchBtn);
	    
	    
	    
	}

/*public By getEmployeeIdCell(String empId) {
    return By.xpath("//div[@class='oxd-table-body']//div[text()='" + empId + "']");
}

public boolean isEmployeeFoundById(String empId)
{
try {
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(getEmployeeIdCell(empId)));
	
	return element.isDisplayed();
}
catch(Exception e)
{
	return false;
}*/



public boolean isSearchResultDisplayed()
{
    try {

        WebElement record = wait.until(
            ExpectedConditions.visibilityOfElementLocated(recordFound)
        );

        System.out.println("Result text is: " + record.getText());

        return record.isDisplayed();

    } catch (Exception e) {

        System.out.println("Record Found element not found");
        e.printStackTrace();

        return false;
    }
}

//update method

public void clickEditIcon()
{
    WebElement edit = wait.until(
        ExpectedConditions.elementToBeClickable(editIcon)
    );

    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", edit);
}


public void updateEmployeeName(String updatedName)
{
    WebElement firstNameField = wait.until(
        ExpectedConditions.visibilityOfElementLocated(editFirstName)
    );

    firstNameField.clear();

    firstNameField.sendKeys(updatedName);

    System.out.println("Updated name entered: " + updatedName);

    // click outside textbox
    firstNameField.sendKeys("\t");

    WebElement saveBtn = wait.until(
        ExpectedConditions.elementToBeClickable(saveEditedDetails)
    );

    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", saveBtn);

    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", saveBtn);

    // wait after save
    wait.until(ExpectedConditions.visibilityOf(firstNameField));
}






public boolean isEmployeeUpdated(String updatedName)
{
    try {

        List<WebElement> firstNameFields =
                driver.findElements(editFirstName);

        for (WebElement field : firstNameFields)
        {
            String value = field.getAttribute("value");

            System.out.println("Field value: " + value);

            if (value.equals(updatedName))
            {
                return true;
            }
        }

        return false;

    } 
    catch (Exception e) {

        return false;
    }
}

//Delete Employee

public void deleteEmployee()
{
    WebElement deleteBtn = wait.until(
        ExpectedConditions.elementToBeClickable(deleteButton)
    );

    deleteBtn.click();

    WebElement confirmBtn = wait.until(
        ExpectedConditions.elementToBeClickable(confirmDeleteButton)
    );

    confirmBtn.click();
}


public boolean isEmployeeDeleted()
{
    try {

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(recordFound)
        );

        String resultText =
            driver.findElement(recordFound).getText();

        return resultText.contains("No Records Found");

    } 
    catch (Exception e) {

        return false;
    }
}
}







	







	
	






