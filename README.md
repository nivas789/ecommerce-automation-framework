# 🛒 E-Commerce Web Application – Automation Testing Framework

A scalable automation testing framework developed using **Java, Selenium WebDriver, TestNG, Maven, REST Assured, Apache POI and Extent Reports**.

The project is designed to demonstrate real-world **Software Development Engineer in Test (SDET)** automation practices including UI automation, API automation, data-driven testing, Page Object Model, test suites, reporting and failure screenshot capture.

---

## 📌 Project Overview

This project automates key workflows of an e-commerce web application and provides a structured automation framework for executing UI and API tests.

The framework follows the **Page Object Model (POM)** design pattern and uses reusable utilities to improve maintainability and scalability.

### Main Objectives

- Automate critical e-commerce user workflows
- Implement maintainable Selenium UI automation
- Implement data-driven testing using Excel
- Execute tests using TestNG
- Generate professional Extent Reports
- Capture screenshots automatically when tests fail
- Automate REST APIs using REST Assured
- Organize tests into Smoke, Regression, Full and API suites
- Build a framework that can be extended for CI/CD and database testing

---

# 🛠️ Technology Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Selenium WebDriver | UI Automation |
| TestNG | Test Framework |
| Maven | Build & Dependency Management |
| REST Assured | API Automation |
| Apache POI | Excel Data-Driven Testing |
| Extent Reports | Test Reporting |
| Google Chrome | Browser |
| Git | Version Control |
| GitHub | Source Code Repository |
| Eclipse | Development Environment |

---

# 🏗️ Framework Architecture

```text
                    E-Commerce Automation Framework
                                |
                +---------------+---------------+
                |                               |
           UI Automation                  API Automation
                |                               |
          Selenium WebDriver              REST Assured
                |                               |
             TestNG                         TestNG
                |                               |
        Page Object Model                API Test Classes
                |
        +-------+-------+
        |       |       |
      Pages   Utils    Base
        |
     Reports
        |
   Extent Reports
        |
 Failure Screenshots
```

---

# 📂 Project Structure

```text
ecommerce-automation-framework
│
├── src
│   │
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseTest.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   └── CheckoutPage.java
│   │   │   │
│   │   │   ├── utils
│   │   │   │   └── WaitUtils.java
│   │   │   │
│   │   │   └── config
│   │   │       └── ConfigReader.java
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       │
│       ├── java
│       │   ├── tests
│       │   │   ├── LoginTest.java
│       │   │   ├── InvalidLoginTest.java
│       │   │   ├── ProductTest.java
│       │   │   └── CheckoutTest.java
│       │   │
│       │   ├── api
│       │   │   └── ProductApiTest.java
│       │   │
│       │   └── utils
│       │       ├── ExcelUtils.java
│       │       ├── TestDataProvider.java
│       │       ├── ExtentReportManager.java
│       │       ├── ExtentTestListener.java
│       │       └── ScreenshotUtils.java
│       │
│       └── resources
│           └── testdata
│               └── LoginData.xlsx
│
├── reports
├── testng-smoke.xml
├── testng-regression.xml
├── testng-full.xml
├── testng-api.xml
├── pom.xml
└── README.md
```

---

# 🧪 UI Automation

The framework currently automates important e-commerce workflows.

## Login Testing

Implemented scenarios:

- Valid login
- Invalid username/password
- Locked user login
- Data-driven login testing using Excel

## Product Testing

The framework verifies:

- Products page
- Product selection
- Add product to cart
- Cart validation

## Checkout Testing

The checkout automation verifies:

- Customer information entry
- Checkout process
- Order completion
- Order confirmation

---

# 📊 Data-Driven Testing

Apache POI is used to read login test data from Excel.

Example:

| Username | Password | Expected Result |
|----------|----------|-----------------|
| standard_user | secret_sauce | success |
| invalid_user | wrong_password | failure |
| locked_out_user | secret_sauce | failure |

Test data location:

```text
src/test/resources/testdata/LoginData.xlsx
```

The TestNG `DataProvider` reads the Excel data and executes the login test for multiple datasets.

---

# 🔌 API Automation

REST Assured is used for API automation.

Currently implemented:

### GET

```text
GET /products/1
```

Validations include:

- HTTP status code
- Product ID
- Product title
- Product price
- Product stock

### POST

```text
POST /products/add
```

Validations include:

- HTTP status code
- Created product title
- Created product price

### PUT

```text
PUT /products/1
```

Validations include:

- HTTP status code
- Updated product title
- Updated product price

### DELETE

```text
DELETE /products/1
```

Validations include:

- HTTP status code
- `isDeleted` response value

---

# 🧪 TestNG Test Suites

## Smoke Suite

```text
testng-smoke.xml
```

Runs critical smoke tests.

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-smoke.xml
```

## Regression Suite

```text
testng-regression.xml
```

Runs regression scenarios.

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-regression.xml
```

## Full Suite

```text
testng-full.xml
```

Runs the complete UI test suite.

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-full.xml
```

## API Suite

```text
testng-api.xml
```

Runs the API automation suite.

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-api.xml
```

---

# 📈 Extent Reports

Extent Reports are integrated into the framework to provide execution reports.

The report contains:

- Test names
- Pass/Fail status
- Execution information
- Project information
- Automation tool information
- Testing framework information
- Programming language information

Report location:

```text
reports/ExtentReport.html
```

---

# 📸 Automatic Failure Screenshots

The framework automatically captures screenshots whenever a test fails.

Screenshots are stored in:

```text
reports/screenshots/
```

The screenshot is also attached to the Extent Report.

---

# ⏳ Explicit Waits

A reusable `WaitUtils` class is implemented using Selenium `WebDriverWait`.

Current reusable waits include:

```java
waitForVisibility()
waitForClickable()
waitForUrlContains()
```

This helps reduce synchronization issues and improves test stability.

---

# ⚙️ Configuration

Application configuration is stored in:

```text
src/main/resources/config.properties
```

Example:

```properties
url=https://www.saucedemo.com/
username=standard_user
password=secret_sauce
browser=chrome
```

> For a public repository, credentials should be moved to environment variables or another secure configuration mechanism rather than storing secrets in Git.

---

# ▶️ How to Run the Project

## Prerequisites

Install:

- Java JDK 21+
- Maven
- Git
- Eclipse or IntelliJ IDEA
- Google Chrome

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

Verify Git:

```bash
git --version
```

## Clone the Repository

```bash
git clone <YOUR-GITHUB-REPOSITORY-URL>
cd ecommerce-automation-framework
```

## Install Dependencies

```bash
mvn clean install
```

## Run UI Smoke Tests

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-smoke.xml
```

## Run UI Regression Tests

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-regression.xml
```

## Run Full UI Suite

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-full.xml
```

## Run API Suite

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-api.xml
```

## Run Individual API Test Class

```bash
mvn -Dtest=api.ProductApiTest test
```

---

# ✅ Current Project Status

| Area | Status |
|------|--------|
| Valid Login | ✅ Completed |
| Invalid Login | ✅ Completed |
| Locked User Login | ✅ Completed |
| Excel Data-Driven Login | ✅ Completed |
| Product / Cart | ✅ Completed |
| Checkout | ✅ Completed |
| Explicit Waits | ✅ Completed |
| TestNG Groups | ✅ Completed |
| Smoke Suite | ✅ Completed |
| Regression Suite | ✅ Completed |
| Full UI Suite | ✅ Completed |
| Extent Reports | ✅ Completed |
| Failure Screenshots | ✅ Completed |
| REST API GET | ✅ Completed |
| REST API POST | ✅ Completed |
| REST API PUT | ✅ Completed |
| REST API DELETE | ✅ Completed |
| Dedicated API Suite | ✅ Completed |
| Reusable API Request Specification | 🔄 In Progress |
| API Negative Testing | ⏳ Planned |
| Database Validation | ⏳ Planned |
| CI/CD with GitHub Actions | ⏳ Planned |
| Advanced Framework Refactoring | ⏳ Planned |

---

# 🚧 Remaining Roadmap

## Phase 1 — API Framework Improvements

- Reusable `RequestSpecification`
- Centralized API base URI
- API request/response logging
- Negative API testing
- Authentication handling
- JSON schema validation

## Phase 2 — Database Testing

- JDBC integration
- Database validation
- UI/API/DB end-to-end validation

## Phase 3 — Framework Improvements

- Better configuration management
- Reusable constants
- Improved exception handling
- Logging
- Parallel execution
- Cross-browser execution

## Phase 4 — CI/CD

- GitHub Actions
- Automated test execution
- Test reports in CI
- Build status tracking

## Phase 5 — Final Documentation

- Test case documentation
- Test execution documentation
- Framework architecture documentation
- SDET interview preparation
- Final project cleanup

---

# 🎯 Learning Outcomes

This project demonstrates practical knowledge of:

- Selenium WebDriver
- Java automation
- TestNG
- Maven
- Page Object Model
- Data-driven testing
- Apache POI
- REST Assured
- API testing
- JSON validation
- TestNG suites
- Extent Reports
- Failure screenshot capture
- Git and GitHub
- Automation framework design

---

# 👨‍💻 Author

**Srinivas**

B.Tech – Computer Science & Engineering

---

# 📌 Project Status

**Active Development 🚀**

The framework is being continuously enhanced with additional API automation, database validation, CI/CD integration and advanced SDET practices.
