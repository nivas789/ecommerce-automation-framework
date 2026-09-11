# 🛒 E-Commerce Web Application – Automation Testing Framework

A maintainable and scalable **Software Development Engineer in Test (SDET) automation framework** developed using **Java, Selenium WebDriver, TestNG, Maven, REST Assured, Apache POI, and Extent Reports**.

The framework automates critical e-commerce application workflows through both **UI automation and REST API testing** and provides structured test execution, data-driven testing, failure screenshots, and HTML reporting.

---

## 📌 Project Overview

The **E-Commerce Web Application Automation Testing Framework** is designed to demonstrate real-world software testing and SDET automation practices.

The framework automates important e-commerce workflows such as:

- User login
- Invalid login validation
- Locked user validation
- Product selection
- Add product to cart
- Cart validation
- Checkout
- Order confirmation

In addition to UI automation, the framework also performs REST API testing for product-related operations such as:

- GET
- POST
- PUT
- DELETE

The project follows the **Page Object Model (POM)** design pattern to make the automation code reusable, maintainable, and easier to scale.

---

# 🎯 Project Objective

The main objective of this project is to build a complete automation testing framework that demonstrates how an SDET can automate both **frontend and backend functionality** of an e-commerce application.

### Key objectives

- Automate critical e-commerce UI workflows
- Implement maintainable Selenium automation
- Follow the Page Object Model design pattern
- Implement explicit waits for reliable execution
- Perform positive and negative testing
- Implement data-driven testing using Excel
- Organize tests using TestNG groups
- Create Smoke, Regression, API, and Full test suites
- Automate REST APIs using REST Assured
- Validate API response data
- Capture screenshots when UI tests fail
- Generate professional Extent HTML reports
- Manage dependencies using Maven
- Maintain the project using Git and GitHub

---

# 🏗️ Framework Architecture

The framework follows a layered automation architecture.

```text
                    E-COMMERCE APPLICATION
                            │
              ┌─────────────┴─────────────┐
              │                           │
             UI                          API
              │                           │
              ▼                           ▼
       Selenium WebDriver          REST Assured
              │                           │
              └─────────────┬─────────────┘
                            │
                            ▼
                    TESTNG TEST LAYER
                            │
              ┌─────────────┼─────────────┐
              │             │             │
          Test Classes   Data Driven   Test Suites
              │             │             │
              │          Apache POI       │
              │             │             │
              └─────────────┼─────────────┘
                            │
                            ▼
                    REPORTING & DEBUGGING
                            │
                ┌───────────┴───────────┐
                │                       │
          Extent Reports          Screenshots
```

---

# 🧰 Technology Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming language |
| Selenium WebDriver | UI/browser automation |
| TestNG | Test execution, assertions, grouping |
| Maven | Build and dependency management |
| REST Assured | REST API automation |
| Apache POI | Excel-based data-driven testing |
| Extent Reports | HTML test reporting |
| Git | Version control |
| GitHub | Source code repository |
| Eclipse IDE | Development environment |
| Chrome | Browser used for UI automation |

---

# 🌐 Applications Used for Testing

## UI Application

The UI automation is implemented against:

**SauceDemo**

Application URL:

```text
https://www.saucedemo.com/
```

The framework validates workflows such as login, products, cart, and checkout.

---

## API Application

REST API automation is implemented using:

**DummyJSON**

Base API:

```text
https://dummyjson.com
```

The framework performs product API operations using REST Assured.

---

# 📂 Project Structure

```text
ecommerce-automation-framework
│
├── .gitignore
├── pom.xml
├── README.md
│
├── reports
│   ├── ExtentReport.html
│   │
│   └── screenshots
│       ├── addProductToCartTest_*.png
│       └── completeCheckoutTest_*.png
│
├── src
│   │
│   ├── main
│   │   │
│   │   ├── java
│   │   │   │
│   │   │   ├── base
│   │   │   │   └── BaseTest.java
│   │   │   │
│   │   │   ├── config
│   │   │   │   └── ConfigReader.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   └── CheckoutPage.java
│   │   │   │
│   │   │   └── utils
│   │   │       └── WaitUtils.java
│   │   │
│   │   └── resources
│   │       └── config.properties
│   │
│   └── test
│       │
│       ├── java
│       │   │
│       │   ├── api
│       │   │   └── ProductApiTest.java
│       │   │
│       │   ├── tests
│       │   │   ├── LoginTest.java
│       │   │   ├── InvalidLoginTest.java
│       │   │   ├── ProductTest.java
│       │   │   └── CheckoutTest.java
│       │   │
│       │   └── utils
│       │       ├── ApiUtils.java
│       │       ├── ExcelUtils.java
│       │       ├── ExtentReportManager.java
│       │       ├── ExtentTestListener.java
│       │       ├── ScreenshotUtils.java
│       │       └── TestDataProvider.java
│       │
│       └── resources
│           └── testdata
│               └── LoginData.xlsx
│
├── testng-api.xml
├── testng-full.xml
├── testng-regression.xml
└── testng-smoke.xml
```

---

# 🧩 Framework Components

## 1. BaseTest

`BaseTest.java`

Provides common WebDriver setup and teardown functionality.

Responsibilities:

- Initialize Chrome WebDriver
- Read configuration
- Open the application URL
- Maximize the browser
- Close the browser after test execution

---

## 2. Page Object Model

The framework follows the **Page Object Model (POM)** design pattern.

Separate page classes are created for different application pages.

### LoginPage

Handles:

- Username input
- Password input
- Login button
- Login workflow

### HomePage

Handles:

- Products page validation
- Add product to cart
- Cart navigation

### CartPage

Handles:

- Cart product validation
- Checkout navigation

### CheckoutPage

Handles:

- First name
- Last name
- Postal code
- Continue button
- Finish button
- Order confirmation

### Benefits of POM

- Reduces code duplication
- Improves maintainability
- Separates test logic from page locators
- Makes the framework easier to modify
- Improves code readability

---

# ⏱️ Explicit Wait Framework

The project contains a reusable:

```text
WaitUtils.java
```

It uses Selenium's `WebDriverWait` and `ExpectedConditions`.

Implemented waits include:

- Wait for element visibility
- Wait for element clickability
- Wait for URL containing specific text

This improves test stability compared with using hard-coded delays such as:

```java
Thread.sleep();
```

---

# 🧪 UI Test Automation

## Login Testing

The login functionality is tested using both valid and invalid credentials.

### Valid Login

The framework verifies that a valid user is successfully redirected to the inventory/products page.

### Invalid Login

The framework verifies that an appropriate error message is displayed for invalid credentials.

### Locked User

The framework verifies that a locked user cannot log in.

---

# 📊 Data-Driven Testing

The project uses:

**Apache POI**

to read login test data from:

```text
src/test/resources/testdata/LoginData.xlsx
```

### Excel Test Data

| Username | Password | Expected Result |
|----------|----------|-----------------|
| standard_user | secret_sauce | success |
| invalid_user | wrong_password | failure |
| locked_out_user | secret_sauce | failure |

The TestNG `DataProvider` reads the Excel data and executes the login test for each dataset.

### Data-Driven Flow

```text
LoginData.xlsx
      ↓
ExcelUtils
      ↓
TestDataProvider
      ↓
TestNG DataProvider
      ↓
LoginTest
      ↓
Execute multiple test scenarios
```

This allows the same test logic to be reused with different input data.

---

# 🛍️ Product Testing

The framework automates the following product workflow:

```text
Login
  ↓
Products Page
  ↓
Select Backpack
  ↓
Add to Cart
  ↓
Open Cart
  ↓
Verify Product
```

The test validates that the selected product is successfully added to the shopping cart.

---

# 🛒 Checkout Testing

The framework automates the complete checkout workflow:

```text
Login
  ↓
Products
  ↓
Add Product
  ↓
Cart
  ↓
Checkout
  ↓
Enter Customer Details
  ↓
Continue
  ↓
Finish Order
  ↓
Verify Order Confirmation
```

Customer details used for test execution are:

```text
First Name: Srinivas
Last Name: Test
Postal Code: 534101
```

---

# 🔴 Negative Testing

Negative scenarios are included to verify how the application behaves when invalid conditions occur.

Implemented scenarios:

### Invalid Credentials

```text
Invalid Username
+
Invalid Password
        ↓
Login
        ↓
Error Message
```

### Locked User

```text
Locked User
+
Valid Password
        ↓
Login
        ↓
Locked User Error
```

Negative testing helps verify that the application handles invalid inputs correctly.

---

# 🔌 API Automation

The framework uses:

**REST Assured**

for backend API automation.

Reusable API configuration is maintained in:

```text
ApiUtils.java
```

The base API URL is:

```text
https://dummyjson.com
```

---

# 🔍 API Test Cases

## GET Product

Endpoint:

```text
GET /products/1
```

Validations include:

- HTTP status code
- Product ID
- Product title
- Product price
- Product stock

Expected HTTP status:

```text
200
```

---

## POST Product

Endpoint:

```text
POST /products/add
```

The test creates a product using a JSON request body.

Example request:

```json
{
  "title": "Test Automation Product",
  "price": 29.99,
  "stock": 50
}
```

Validations include:

- HTTP status code
- Product title
- Product price

Expected HTTP status:

```text
201
```

---

## PUT Product

Endpoint:

```text
PUT /products/1
```

The test updates product information.

Example request:

```json
{
  "title": "Updated Automation Product",
  "price": 39.99
}
```

Validations include:

- HTTP status code
- Updated product title
- Updated product price

Expected HTTP status:

```text
200
```

---

## DELETE Product

Endpoint:

```text
DELETE /products/1
```

Validations include:

- HTTP status code
- `isDeleted` response value

Expected HTTP status:

```text
200
```

---

# 🔄 API Automation Flow

```text
REST API
   │
   ▼
Request Specification
   │
   ▼
REST Assured
   │
   ▼
Send HTTP Request
   │
   ▼
Receive Response
   │
   ▼
Validate Status Code
   │
   ▼
Validate Response Data
   │
   ▼
Test Result
```

---

# 🧪 TestNG

TestNG is used as the main testing framework.

The project uses:

- `@Test`
- `@BeforeMethod`
- `@AfterMethod`
- `@DataProvider`
- Assertions
- Test groups
- TestNG XML suites
- Test listeners

---

# 🏷️ Test Groups

Tests are organized into:

### Smoke

Used for critical functionality that should be checked quickly.

```text
smoke
```

### Regression

Used for broader functional validation.

```text
regression
```

---

# 📋 TestNG Test Suites

The project contains four TestNG XML suites.

## Smoke Suite

```text
testng-smoke.xml
```

Runs tests belonging to the:

```text
smoke
```

group.

---

## Regression Suite

```text
testng-regression.xml
```

Runs tests belonging to the:

```text
regression
```

group.

---

## API Suite

```text
testng-api.xml
```

Runs API automation tests.

---

## Full Suite

```text
testng-full.xml
```

Runs both:

```text
UI Tests
+
API Tests
```

This is the main complete execution suite.

---

# 📈 Extent Reports

The project integrates:

**Extent Reports**

to generate an HTML test execution report.

Report location:

```text
reports/ExtentReport.html
```

The report provides information about:

- Test names
- Test execution status
- Passed tests
- Failed tests
- Skipped tests
- Failure information
- Execution details

---

# 📸 Automatic Failure Screenshots

The framework automatically captures screenshots when a UI test fails.

Screenshots are stored under:

```text
reports/screenshots/
```

Example:

```text
addProductToCartTest_*.png
completeCheckoutTest_*.png
```

The screenshot functionality is implemented using:

```text
ScreenshotUtils.java
```

and integrated with:

```text
ExtentTestListener.java
```

### Failure Handling Flow

```text
Test Execution
      ↓
Test Failure
      ↓
ExtentTestListener
      ↓
Capture Screenshot
      ↓
Save Screenshot
      ↓
Attach Screenshot to Report
```

This makes debugging failed UI tests easier.

---

# 🔧 Extent Test Listener

The framework implements a custom TestNG listener:

```text
ExtentTestListener.java
```

The listener handles:

- Test start
- Test success
- Test failure
- Test skipped
- Screenshot capture on failure
- Screenshot attachment to Extent Report
- Final report generation

---

# ⚙️ Configuration Management

Application configuration is maintained in:

```text
src/main/resources/config.properties
```

Current configuration includes:

```properties
url=https://www.saucedemo.com/
username=standard_user
password=secret_sauce
browser=chrome
```

The configuration is read using:

```text
ConfigReader.java
```

This avoids hard-coding application configuration throughout the test classes.

---

# 📦 Maven

Maven is used for:

- Dependency management
- Project build
- Test execution
- TestNG suite execution

The project uses a `pom.xml` file to manage dependencies.

### Main Dependencies

```text
Selenium Java
TestNG
REST Assured
Apache POI
Extent Reports
```

---

# ▶️ How to Run the Project

## Prerequisites

Install the following:

- Java JDK
- Maven
- Git
- Eclipse IDE or another Java IDE
- Google Chrome

---

# 1. Clone the Repository

```bash
git clone https://github.com/nivas789/ecommerce-automation-framework.git
```

Move into the project:

```bash
cd ecommerce-automation-framework
```

---

# 2. Verify Java

```bash
java -version
```

The project is configured to compile using Java 21.

---

# 3. Verify Maven

```bash
mvn -version
```

---

# 4. Run Smoke Tests

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-smoke.xml
```

---

# 5. Run Regression Tests

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-regression.xml
```

---

# 6. Run API Tests

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-api.xml
```

---

# 7. Run Complete UI + API Suite

```bash
mvn test -Dsurefire.suiteXmlFiles=testng-full.xml
```

The full suite executes both UI and API tests.

---

# ✅ Current Test Execution Result

The complete framework was successfully executed.

Final execution result:

```text
Tests run: 11
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

### Test Distribution

```text
UI Automation
     ↓
7 Tests
     ↓
PASS

API Automation
     ↓
4 Tests
     ↓
PASS

-------------------
Total: 11 Tests
Passed: 11
Failed: 0
```

---

# 📊 Current Test Coverage

| Area | Test Type | Status |
|------|-----------|--------|
| Valid Login | UI | ✅ |
| Invalid Login | UI | ✅ |
| Locked User Login | UI | ✅ |
| Product / Cart | UI | ✅ |
| Checkout | UI | ✅ |
| Data-Driven Login Scenarios | UI | ✅ |
| API GET Product | API | ✅ |
| API POST Product | API | ✅ |
| API PUT Product | API | ✅ |
| API DELETE Product | API | ✅ |
| Extent Reporting | Reporting | ✅ |
| Failure Screenshots | Reporting | ✅ |

---

# 🧠 Real-World Use Case

In a real e-commerce company, developers continuously modify application functionality.

For example:

```text
Developer changes Login
        ↓
Developer changes Cart
        ↓
Developer changes Checkout
        ↓
New application build
```

The QA/SDET team needs to verify that existing functionality has not been broken.

Instead of manually testing every workflow, an automation framework can execute the tests automatically.

```text
New Build
   ↓
Smoke Tests
   ↓
Regression Tests
   ↓
API Tests
   ↓
Full Automation Suite
   ↓
Test Results
   ↓
Extent Report
```

This helps organizations:

- Reduce manual testing effort
- Detect defects earlier
- Improve regression coverage
- Execute repetitive tests quickly
- Generate consistent test results
- Improve debugging
- Increase confidence before releases

---

# 🌍 Where This Framework Can Be Used

The same automation framework concepts can be applied to many domains.

### E-Commerce

- Login
- Product search
- Cart
- Checkout
- Orders
- Payments
- APIs

### Banking

- Login
- Account management
- Transactions
- Fund transfers
- Transaction history

### Healthcare

- Patient login
- Appointment booking
- Doctor selection
- Patient records

### Travel

- Flight search
- Hotel booking
- Passenger details
- Booking confirmation

The application changes, but the underlying automation concepts remain similar.

---

# 🧪 Testing Approach

The project follows multiple testing approaches.

### Functional Testing

Verifies that application functionality works as expected.

### Positive Testing

Uses valid inputs and verifies successful workflows.

### Negative Testing

Uses invalid inputs and verifies proper error handling.

### Regression Testing

Ensures existing functionality continues to work after changes.

### Smoke Testing

Quickly validates critical application functionality.

### Data-Driven Testing

Executes the same test with multiple sets of external data.

### UI Automation

Automates browser-based application workflows.

### API Automation

Validates backend REST API functionality.

---

# 📐 Design Principles Used

The framework follows several automation best practices.

### Page Object Model

Separates page-specific elements and actions from test cases.

### Reusable Utilities

Common functionality is centralized into utility classes.

### Explicit Waits

Improves synchronization with web elements.

### TestNG Groups

Allows selective execution of test categories.

### Data-Driven Testing

Separates test data from test logic.

### Listener-Based Reporting

Centralizes reporting and failure handling.

### Configuration Management

Stores application configuration separately from test code.

---

# 🗂️ Important Classes

| Class | Responsibility |
|-------|----------------|
| `BaseTest` | WebDriver setup and teardown |
| `ConfigReader` | Reads configuration properties |
| `LoginPage` | Login page actions |
| `HomePage` | Product page actions |
| `CartPage` | Cart operations |
| `CheckoutPage` | Checkout operations |
| `WaitUtils` | Explicit wait utilities |
| `LoginTest` | Data-driven login testing |
| `InvalidLoginTest` | Negative login testing |
| `ProductTest` | Product/cart testing |
| `CheckoutTest` | Checkout workflow testing |
| `ProductApiTest` | REST API testing |
| `ApiUtils` | Reusable API configuration |
| `ExcelUtils` | Excel data reading |
| `TestDataProvider` | TestNG data provider |
| `ExtentReportManager` | Extent report configuration |
| `ExtentTestListener` | Test result handling |
| `ScreenshotUtils` | Failure screenshot capture |

---

# 🔐 Test Data

Login test data is maintained separately in:

```text
src/test/resources/testdata/LoginData.xlsx
```

This demonstrates the separation of:

```text
Test Logic
     +
Test Data
```

which improves maintainability and makes it easier to add additional test scenarios.

---

# 📌 Git & GitHub

The project is maintained using Git for version control and hosted publicly on GitHub.

Repository:

```text
https://github.com/nivas789/ecommerce-automation-framework
```

The project includes:

```text
Git repository
Git commits
main branch
GitHub remote repository
```

The complete project has been successfully pushed to GitHub.

---

# 🏆 Key Features

```text
✅ Selenium WebDriver
✅ Java
✅ TestNG
✅ Maven
✅ Page Object Model
✅ Explicit Waits
✅ Positive Testing
✅ Negative Testing
✅ Data-Driven Testing
✅ Apache POI
✅ Smoke Testing
✅ Regression Testing
✅ REST API Automation
✅ REST Assured
✅ GET API Testing
✅ POST API Testing
✅ PUT API Testing
✅ DELETE API Testing
✅ TestNG XML Suites
✅ Extent Reports
✅ Failure Screenshots
✅ Custom TestNG Listener
✅ Configuration Management
✅ Git
✅ GitHub
```

---

# 🚀 Future Enhancements

The current framework is complete for the implemented scope. The following features can be added in future versions:

- Cross-browser testing
- Parallel test execution
- JDBC/database validation
- More UI test cases
- More API test scenarios
- Environment-specific configuration
- Advanced logging
- CI/CD integration using GitHub Actions
- Automated test execution on every GitHub push
- Docker-based test execution
- Advanced API schema validation
- Additional reporting enhancements

These are planned enhancements and are not part of the current completed implementation.

---

# 💼 Skills Demonstrated

This project demonstrates practical knowledge of:

### Programming

- Java
- Object-Oriented Programming

### UI Automation

- Selenium WebDriver
- Locators
- WebDriverWait
- Expected Conditions
- Page Object Model

### Test Automation

- TestNG
- Assertions
- Data Providers
- Test Groups
- TestNG XML

### API Testing

- REST Assured
- HTTP methods
- GET
- POST
- PUT
- DELETE
- JSON response validation

### Test Data

- Apache POI
- Excel-based data-driven testing

### Reporting

- Extent Reports
- TestNG Listeners
- Failure screenshots

### Build & Version Control

- Maven
- Git
- GitHub

---

# 🎤 Interview Project Explanation

### Short Version

> I developed an E-Commerce Web Application Automation Testing Framework using Java, Selenium WebDriver, TestNG, Maven, REST Assured, Apache POI, and Extent Reports. I automated critical UI workflows such as login, negative login scenarios, product selection, cart, and checkout using the Page Object Model. I also implemented data-driven testing using Excel and REST API automation for GET, POST, PUT, and DELETE operations. The framework includes TestNG smoke, regression, API, and full suites, along with automatic failure screenshots and Extent HTML reporting. The complete suite currently executes 11 tests successfully with zero failures.

---

# 📚 What This Project Demonstrates

This project demonstrates how an SDET automation framework can be designed from the ground up.

The framework covers the complete flow:

```text
Application
     ↓
Test Planning
     ↓
UI Automation
     ↓
API Automation
     ↓
Data-Driven Testing
     ↓
TestNG Execution
     ↓
Smoke / Regression Suites
     ↓
Failure Handling
     ↓
Screenshots
     ↓
Extent Reports
     ↓
Git / GitHub
```

---

# 👨‍💻 Author

**Nivas789**

GitHub:

```text
https://github.com/nivas789
```

Project Repository:

```text
https://github.com/nivas789/ecommerce-automation-framework
```

---

# ⭐ Project Status

```text
PROJECT STATUS: COMPLETED ✅

UI Automation:       ✅
API Automation:      ✅
Data-Driven Testing: ✅
TestNG Suites:       ✅
Extent Reporting:    ✅
Screenshots:         ✅
Git/GitHub:           ✅
Full Execution:      ✅

Tests Executed:      11
Tests Passed:        11
Tests Failed:         0
```

---

## 📌 Conclusion

The **E-Commerce Web Application – Automation Testing Framework** demonstrates a practical SDET approach to automating web and API testing.

By combining Selenium WebDriver, TestNG, Maven, REST Assured, Apache POI, Page Object Model, Extent Reports, failure screenshots, and Git/GitHub, the project provides a structured and maintainable foundation for real-world automation testing.
