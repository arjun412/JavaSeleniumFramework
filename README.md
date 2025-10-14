# JavaSeleniumFramework

# 🚀 Java Selenium Test Automation Framework

This is a **Hybrid Automation Framework** built using **Java, Selenium, TestNG, and Maven**.  
It is designed for maintainability, scalability, and parallel execution, with detailed HTML reporting and retry logic for failed tests.

---

## 🧩 Key Features

- **Java + Selenium + TestNG + Maven** based hybrid automation framework  
- Supports **parallel execution** and **tag/group-based execution**  
- Integrated **retry logic** to re-run failed tests up to 2 times  
- Generates beautiful **Extent HTML reports** with screenshots for failed tests  
- Modular and maintainable **Page Object Model (POM)** structure  
- Configurable via **config.properties** file  
- Supports **GitHub + Jenkins + Docker** integration for CI/CD pipelines  

---

## ⚙️ Prerequisites

Make sure the following software is installed before running the tests:

| Software | Version | Purpose |
|-----------|----------|----------|
| **Java JDK** | 17 or above | To run and compile Java code |
| **Maven** | 3.8+ | Build and dependency management |
| **TestNG** | Latest | Testing framework |
| **Git** | Latest | Version control |
| **Chrome / Edge Browser** | Latest | Browser for Selenium |
| **WebDriver (ChromeDriver/EdgeDriver)** | Compatible version | Required for browser automation |
| **IDE** | IntelliJ IDEA / Eclipse | To view and run code locally |
| **Jenkins (Optional)** | Latest | For CI/CD pipeline setup |
| **Docker (Optional)** | Latest | To run Jenkins + Selenium in isolated containers |

---

## 🧱 Framework Components Overview

| Component | Description |
|------------|-------------|
| **BaseTest.java** | Initializes WebDriver before each test and quits it afterward |
| **Constants Folder** | Contains reusable constants like XPath and static variables |
| **Listeners Folder** | Contains TestNG listeners for event tracking and retry logic |
| **Pages Folder** | Contains Page Object classes and related methods |
| **Utilities Folder** | Helper classes for configuration, waits, reporting, retries, and screenshots |
| **Reports Folder** | Contains Extent HTML reports and failed test screenshots |
| **Resources Folder** | Config and TestNG XML files for test execution |

---

## 🧪 Running Tests

You can execute your tests in **multiple ways:**

### 🧍 1. Run a Single Test
- Navigate to `src/test/java/com/selenium/tests`
- Open any test file
- Click the **Run** icon next to a single test method in your IDE.

### 🧑‍🤝‍🧑 2. Run All Tests in a Class
- Click the **Run** icon next to the test class in your IDE.

### 🧰 3. Run All Tests in the Project
- Run the **TestNG suite file:**

### 🧩 4. Run Only Sanity Tagged Tests
- Run the **tag-based TestNG file:**

### 💻 5. Run Tests using Maven (Command Line)
- mvn clean test

### 💻 6. Run Sanity Tests using Maven (Command Line)
- mvn clean test -Dgroups=sanity
---

## 🔁 Retry Mechanism
- Implemented using RetryAnalyzer.java
- If a test fails, it is retried up to 2 times before being marked as failed.
- Controlled via RetryListener.java which dynamically attaches the retry logic to each test.
---

## 📊 Reports and Logs

- After every execution:
 1) A detailed Extent HTML report is generated inside the reports/ folder
 2) Screenshots of failed test cases are saved under reports/screenshots/
 3) Reports include:
    - Test name & description
    - Step-level logging
    - Status (PASS/FAIL/SKIP)
    - Exception details
    - Embedded screenshots
<img width="1915" height="873" alt="image" src="https://github.com/user-attachments/assets/8215acdf-a6ed-4798-81ab-5eae9102cd6e" />

## 👨‍💻 Author

**Arjunkumar Shah**  
📍 Toronto, ON, Canada  
📧 [shaharjun035@gmail.com](mailto:shaharjun035@gmail.com)  
📞 +1 (437) 665-9442  
🔗 [LinkedIn Profile](https://linkedin.com/in/arjun-shah-71270a91)
