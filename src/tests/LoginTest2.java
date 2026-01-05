package tests;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest2 extends BaseTest {

    public static void main(String[] args) {

        // Create object of test class
        LoginTest2 test = new LoginTest2();

        // Setup browser
        test.setUp();

        // Open application
        test.driver.get("https://www.saucedemo.com");

        // Use LoginPage (POM)
        LoginPage loginPage = new LoginPage(test.driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Validation
        String currentUrl = test.driver.getCurrentUrl();

        if (currentUrl.contains("inventory")) {
            System.out.println("LOGIN TEST 2 PASSED");
        } else {
            System.out.println("LOGIN TEST 2 FAILED");
        }

      
    }
}
