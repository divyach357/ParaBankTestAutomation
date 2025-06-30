# Parabank Registration Validation Test Suite

This project automates **registration validation scenarios** on [Parabank](https://parabank.parasoft.com/parabank/) using Selenium WebDriver with:

## ⚙️ Features Implemented

✅ **Page Object Model**
- All locators and actions are defined in `RegistrationPage.java`.
- Error elements are mapped with a `Map<String, By>` for dynamic retrieval.

✅ **POJO**
- `RegistrationData.java` maps JSON payloads to Java objects.
- Each JSON test case defines:
  - The field to be left empty.
  - Expected error messages.
  - Remaining field values.

✅ **DataProvider**
- Reads all test cases from JSON.
- Injects data into TestNG tests automatically.

✅ **Dynamic Field Input**
- Uses a `switch` block to fill each field.
- Ensures only relevant fields are populated for each scenario.

✅ **Dynamic Error Validation**
- Based on the field name, the error locator is retrieved via `Map` and asserted.

✅ **TestNG XML**
- Parallel execution enabled across multiple test methods.
- Flexible suite configuration (`testng.xml`).

**🧩 How It Works

Data Loading:

DataProviderClass reads registrationTestData.json into a list of RegistrationData POJOs.

Each object represents one negative test scenario.

Test Execution :

RegistrationValidationTest receives each RegistrationData instance.

All fields are filled dynamically (empty fields left blank).

Form is submitted.

The error corresponding to the missing field is asserted.

Error Retrieval:

A Map<String, By> inside RegistrationPage maps field names to their error locators.

getErrorMessage(String field) retrieves and returns the error text dynamically.

Parallel Runs:

The TestNG suite allows tests to run concurrently for faster feedback.

---
