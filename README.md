# Selenium Automation Framework – QA Project

This project is a **Selenium Automation Testing Framework** built using **Java** and **Page Object Model (POM)** to automate and validate core features of an e-commerce web application.

The framework is designed with **real-world QA practices**, focusing on maintainability, reusability, and clear validation logic.

---

## 🔧 Tech Stack
- Java
- Selenium WebDriver
- Eclipse IDE
- Page Object Model (POM)
- Git & GitHub

---

## 🌐 Application Under Test
- Website: https://www.saucedemo.com  
- Domain: E-commerce (Product listing, Cart, Checkout)

---

## 📂 Project Structure
## 📂 Project Structure

```text
SeleniumSetup
├── src
│   ├── base
│   │   └── BaseTest.java
│   │
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── InventoryPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │   └── CheckoutOverviewPage.java
│   │
│   ├── tests
│   │   ├── LoginTest.java
│   │   ├── LoginNegativeTest.java
│   │   ├── LogoutTest.java
│   │   ├── CartPageTest.java
│   │   ├── RemoveFromCartTest.java
│   │   └── CheckoutTest.java
│   │
│   └── utils
│       ├── ScreenshotUtil.java
│       ├── WaitUtil.java
│       └── AssertUtil.java
│
├── screenshots
├── .gitignore
└── README.md
```

---

## 🧠 Framework Design Overview

### 🔹 Base Layer
- **BaseTest**
  - Handles browser setup and teardown
  - Centralized WebDriver management

### 🔹 Page Layer (POM)
- Each page represents a web screen
- Contains only locators and page actions
- No validations inside page classes

### 🔹 Test Layer
- Contains test scenarios and validations
- Uses custom assertions
- Screenshots captured only on failures

### 🔹 Utility Layer
- **AssertUtil** – Handles test pass/fail logic
- **WaitUtil** – Centralized explicit waits
- **ScreenshotUtil** – Captures screenshots on failures

---

## ✅ Test Scenarios Automated

### 🔐 Authentication
- Valid Login
- Invalid Login (Negative Testing)
- Logout

### 🛒 Cart & Product Features
- Verify product listing
- Add product to cart
- Cart page validation
- Remove product from cart

### 💳 Checkout Flow
- End-to-end checkout process
- User details entry
- Order completion validation
- Success message verification

---

## 📸 Screenshot Handling
- Screenshots are captured **only when a test fails**
- Stored in:
- Helps in debugging and defect analysis

---

## ⏱ Wait Handling
- Explicit waits using `WebDriverWait`
- No use of `Thread.sleep`
- Improves test stability and reliability

---

## ▶️ How to Run Tests
1. Clone the repository
2. Open project in Eclipse
3. Navigate to:
4. Right-click any test class
5. Run as **Java Application**

---

## 📌 Key QA Concepts Demonstrated
- Manual test case design
- Functional & negative testing
- Regression testing approach
- Page Object Model (POM)
- Explicit waits
- Assertion & validation best practices
- Screenshot capture on failure
- GitHub version control

---

## 🚀 Future Enhancements
- TestNG integration
- Data-driven testing using Excel
- API testing (REST)
- CI/CD integration (Jenkins)
- Advanced reporting (Extent Reports)

---

## 👤 Author
**Shubham Karangale**  
MCA (2026) | Aspiring QA / Automation Test Engineer  

---

## ⭐ Note
This project is created for **learning, practice, and interview preparation**, following **industry-standard QA automation practices**.
