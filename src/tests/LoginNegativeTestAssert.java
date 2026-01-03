package tests;

import base.BaseTest;
import pages.LoginPage;
import utils.AssertUtil;

public class LoginNegativeTestAssert extends BaseTest {

    public static void main(String[] args) {

        LoginNegativeTest test = new LoginNegativeTest();
        test.setUp();

        test.driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(test.driver);

        // Invalid credentials
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        // Validation
        String errorText = loginPage.getErrorMessage();
      

     // after getting errorText
     boolean isErrorCorrect =
             errorText.contains("Username and password do not match");

     AssertUtil.assertTrue(
             isErrorCorrect,
             "Error message is incorrect or not displayed",
             test.driver,
             "NegativeLoginAssertionFailure"
     );

        test.tearDown();
    }
}
