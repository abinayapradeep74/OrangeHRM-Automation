# OrangeHRM Automation Framework
-----------------------------------------
A scalable and maintainable **Selenium Test Automation Framework** for OrangeHRM using Java, TestNG, and Maven. Built following **Page Object Model (POM)** design pattern with data-driven testing and advanced reporting.

---

# Tech Stack
-----------------

- **Language:** Java  
- **Automation:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build & Dependency Management:** Maven  
- **Data Management:** Excel, JSON  
- **Logging:** Log4j2  
- **Reporting:** Extent Reports  
- **Version Control:** Git & GitHub  

---

# Project Structure
---------------------------

orangehrm-automation-framework/
│
├── src/
│ ├── main/java # (Optional for utilities if needed)
│ └── test/java # Test classes, page objects, utilities
├── src/test/resources # Test data (Excel, JSON, log4j2.xml)
├── .gitignore # Ignore logs, reports, target folder
├── pom.xml # Maven dependencies
├── config.properties # Browser and URL configuration
└── README.md


---

# Key Features
--------------------

- **Reusable Base Test Setup:** Handles browser setup and teardown  
- **Page Object Model (POM):** Keeps locators and page actions separate for maintainability  
- **Data-Driven Testing:** Supports Excel & JSON for flexible test data  
- **Config Reader:** Easily manage environment, browser, and URL settings  
- **Logging:** Tracks test execution with Log4j2  
- **Reports:** Generate detailed HTML reports with Extent Reports  
- **Maven:** Manage dependencies and run tests with `mvn test`  
- **Git:** Version controlled for collaboration and continuous integration  

---

# How to Run Tests
-----------------------
1. Clone the repository:

</ bash>

git clone https://github.com/abinayapradeep74/OrangeHRM-Automation.git

2. Open in Eclipse or IntelliJ IDEA
3. Install dependencies:

</bash>
mvn clean install

4. Run tests:
</bash>
mvn test

TestNG XML files are located under src/test/java/tests/


Reports
-----------
1. Extent Reports are generated automatically in test-output/ExtentReport.html after each run
2. Logging files are saved in the logs/ folder

How to Contribute
-----------------------
1. Fork the repo
2. Create your feature branch: git checkout -b feature/your-feature
3. Commit your changes: git commit -m "Add some feature"
4. Push to the branch: git push origin feature/your-feature
5. Create a pull request

✅ Best Practices Followed
---------------------------
Clean repo with .gitignore to exclude logs, reports, target folder
Modular design with POM and reusable utilities
Data-driven approach for flexibility and scalability
Version control with Git for professional workflow

📌 Future Enhancements
--------------------------
Parallel test execution (TestNG)
Cross-browser testing with multiple drivers
CI/CD integration (Jenkins / GitHub Actions)
Screenshot on test failure

🔗 GitHub Repository
--------------------
OrangeHRM Automation Framework

👨‍💻 Author
------------
Abinaya Maruthamuthu

Email: abinayapradeep74@gmail.com
LinkedIn: https://www.linkedin.com/in/abinaya-maruthamuthu-754359272/