# Mobile Test Automation Framework - Patient Mobile App

A robust, cross-platform mobile test automation framework designed using **Java**, **Appium**, **SHAFT Engine**, and **TestNG**. This repository automates the end-to-end user workflows for the Patient Mobile App (Scan and Lab visit bookings, non-insurance/insurance prescription uploads, and payment processing).

---

## 🏗️ Framework Architecture & Best Practices

The framework is structured following industry-standard design patterns and clean code principles:

* **Page Object Model (POM):** Decouples UI locators and user interactions from test cases to maximize code reusability and maintainability.
* **BaseTest Hierarchy:** Standardizes initialization, teardown (`@BeforeMethod`, `@AfterMethod`), app resetting, and standard authentication flows.
* **Data-Driven Testing (DDT):** Integrates SHAFT's JSON Test Data Engine (`SHAFT.TestData.JSON`) to separate credentials, payment values, and file paths from code logic.
* **Device File Utilities:** Encapsulates custom Appium device-interaction procedures (e.g., pushing test attachments via `AndroidDriver`).

---

## 📁 Project Structure

```text
Patient mobile app/
├── src/
│   ├── main/
│   │   java/
│   │   ├── pages/                   # Page Object Model classes
│   │   │   ├── BasePage.java
│   │   │   ├── LoginPage.java
│   │   │   ├── HomePage.java
│   │   │   ├── BookingPage.java
│   │   │   ├── CartAndCheckoutPage.java
│   │   │   └── FileUploadPage.java
│   │   └── utils/                   # Device helper utilities
│   │       └── FileUploadUtils.java
│   └── test/
│       ├── java/
│       │   └── testPackage/         # TestNG test suites
│       │       ├── BaseTest.java
│       │       ├── ScanTests.java
│       │       └── LabTests.java
│       └── resources/
│           └── testDataFiles/       # JSON test data & static media
│               ├── simpleJSON.json
│               └── Attachment.png
├── pom.xml                          # Maven dependencies (SHAFT, TestNG, Appium)
├── .gitignore                       # Binaries, reports, and build exclusions
└── README.md