# OrangeHRM Automation Framework

## About the Project

This project is a Selenium Java Automation Framework developed for automating key HR work flows in the OrangeHRM application using the Page Object Model (POM) design pattern.

The framework currently covers end-to-end Employee Management operations including Add, Search, Update, and Delete functionalities with reusable utilities, reporting, and CI/CD integration.

---

## Tech Stack Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Extent Reports
* JSON Data Handling
* Git & GitHub
* CI/CD Integration

---

## Features Implemented

### Login Functionality

* Valid login automation
* Login validation using assertions

### Add Employee

* Add new employee
* Dynamic employee ID generation
* Employee creation validation

### Search Employee

* Search employee using employee name
* Auto-suggestion handling
* Search result validation

### Update Employee

* Navigate to Employee List
* Search and open employee profile
* Update employee details
* Validate updated information

### Delete Employee

* Delete employee record
* Handle confirmation popup
* Validate deleted employee record

---

## Selenium Concepts Used

* Explicit Waits (WebDriverWait)
* Dynamic XPath Handling
* JavaScriptExecutor

  * Scroll Into View
  * JavaScript Click
* Dynamic Web Element Validation
* Auto-Suggestion Handling
* Exception Handling

---

## Utilities Implemented

* ConfigReader
* JSON Reader
* Screenshot Utility
* BaseTest Setup
* Extent Report Integration

---

## Reporting

Extent Reports are integrated for:

* Test execution status
* Logs
* Screenshots
* Failure tracking

---

## CI/CD Integration

The framework is integrated with CI/CD process for automated test execution.

---

## Project Structure

src/test/java

* pages
* tests
* utilities
* base

src/test/resources

* config.properties
* AddEmployee.json

---

## How to Run

1. Clone the repository
2. Open project in Eclipse or IntelliJ
3. Install Maven dependencies
4. Run TestNG XML file
5. View Extent Reports after execution

---

## Future Enhancements

* Cross-browser testing
* Parallel execution
* Retry Analyzer
* API Automation
* SQL Validation

---

## Author
Automation Test Engineer
Selenium | Java | TestNG | CI/CD
