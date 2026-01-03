package tests;

import base.BaseTest;
import pages.LoginPage;
import utils.ScreenshotUtil;

public class LoginNegativeTestScreenshot extends BaseTest {

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
        String errorText = loginPage.ge			tErrorMessage();

        boolean isErrorDisplayedCorrectly =
                errorText.contains("Username and password do not match");

        if (isErrorDisplayedCorrectly) {
            System.out.println("NEGATIVE LOGIN TEST PASSED");
        } else {
            System.out.println("NEGATIVE LOGIN TEST FAILED");
            ScreenshotUtil.takeScreenshot(test.driver, "NegativeLoginFailure");
        }

        test.tearDown();
    }
}
