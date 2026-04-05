![CI](https://github.com/abinayapradeep74/OrangeHRM-Automation/actions/workflows/ci.yml/badge.svg)

## OrangeHRM Automation Framework (Enterprise-Ready)
-------------------------------------------------

A scalable, maintainable, and CI-ready Selenium automation framework built to test the OrangeHRM application. Designed using industry best practices to simulate real-world QA automation in enterprise environments.

## Project Status
-----------------

This project is actively being enhanced with real-world features such as:

CI/CD integration
API automation
Docker execution
Parallel test execution

## Business Use Case
------------------------

This framework automates critical HR workflows in OrangeHRM, including:

User authentication and role-based access
Employee management
Admin functionalities
Form validations and UI workflows

Objective:
------------
To reduce manual regression effort and improve release quality through reliable automation.

## Highlights
---------------
Designed using Page Object Model (POM) for high maintainability
Supports data-driven testing using Excel & JSON
Integrated logging and reporting for debugging and traceability
Built with scalability in mind (parallel execution ready)
Easily extendable for CI/CD pipelines and cloud execution

## Tech Stack
----------------
Language: Java
UI Automation: Selenium WebDriver
Test Framework: TestNG
Build Tool: Maven
Data Handling: Apache POI (Excel), JSON
Logging: Log4j2
Reporting: Extent Reports
Version Control: Git (GitHub)
🏗️ Framework Architecture

The framework follows a Layered Test Architecture:

Page Layer: Page Object classes (UI interactions)
Test Layer: TestNG test cases
Utility Layer: Reusable helper methods
Config Layer: Environment & configuration management
Designed For:
Reusability
Maintainability
Scalability

## Key Features
----------------
🔹 Centralized Base Test setup for browser lifecycle management
🔹 Externalized configuration (browser, environment, URL)
🔹 Reusable utilities for common actions
🔹 Detailed HTML reporting using Extent Reports
🔹 Structured logging using Log4j2
🔹 Data-driven test execution

##Test Coverage
------------------
Login functionality (valid & invalid scenarios)
Employee management workflows
Form validations and UI interactions

Execution
-------------
Run the tests using Maven:

mvn clean test

## Reports & Logs
------------------
Extent Reports generated at:
/test-output/ExtentReport.html

## Logs available under:
---------------------------
/logs/

## Real-World Impact
----------------------
Reduces manual testing effort through automation
Improves regression test coverage
Enables faster feedback with CI-ready execution
Supports scalable and maintainable test design

## Roadmap (Continuous Improvement)
----------------------------------------

Parallel execution using TestNG

CI/CD integration using Jenkins / GitHub Actions

Cross-browser testing (Chrome, Firefox, Edge)

Docker-based execution

API testing integration (RestAssured)

Cloud execution (Selenium Grid / BrowserStack)

Screenshot capture on test failure

Retry mechanism for flaky tests

##Contribution
---------------
Fork the repository
Create your feature branch:
git checkout -b feature/your-feature
Commit your changes:
git commit -m "Add new feature"
Push to the branch:
git push origin feature/your-feature
Open a Pull Request

##Author

Abinaya Maruthamuthu

abinayapradeep74@gmail.com

🔗 LinkedIn: https://www.linkedin.com/in/abinaya-maruthamuthu-754359272/
