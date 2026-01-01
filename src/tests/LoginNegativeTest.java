package tests;

import base.BaseTest;
import utils.ScreenshotUtil;
import pages.LoginPage;

public class LoginNegativeTest extends BaseTest {

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
       
        boolean isErrorCorrect =
                errorText.contains("Username and password do not match");

        if (!isErrorCorrect) {
            ScreenshotUtil.takeScreenshot(test.driver, "NegativeLoginFailure");
            System.out.println("NEGATIVE LOGIN TEST FAILED");
        } else {
            System.out.println("NEGATIVE LOGIN TEST PASSED");
        }


     /* after validation
        if (!errorText.contains("Username and password do not match")) {
             ScreenshotUtil.takeScreenshot(test.driver, "NegativeLoginFailure");
            }

        if (errorText.contains("Username and password do not match")) {
            System.out.println("NEGATIVE LOGIN TEST PASSED");
        } else {
            System.out.println("NEGATIVE LOGIN TEST FAILED");
        }*/

        test.tearDown();
    }
}
