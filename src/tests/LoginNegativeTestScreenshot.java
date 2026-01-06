package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ScreenshotUtil;

public class LoginNegativeTestScreenshot extends BaseTest {

    @Test
    public void negativeLoginScreenshotTest() {

        // Extent report entry
        testReport = extent.createTest("Negative Login Test with Screenshot");

        testReport.info("Opening application");
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);

        testReport.info("Entering invalid credentials");
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        testReport.info("Validating error message");
        String errorText = loginPage.getErrorMessage();

        boolean isErrorDisplayedCorrectly =
                errorText.contains("Username and password do not match");

        if (!isErrorDisplayedCorrectly) {
            ScreenshotUtil.takeScreenshot(driver, "NegativeLoginFailure");
            testReport.fail("Error message validation failed");
        } else {
            testReport.pass("Negative login validation successful");
        }

        // TestNG assertion (final authority)
        org.testng.Assert.assertTrue(
                isErrorDisplayedCorrectly,
                "Error message is incorrect or not displayed"
        );
    }
}
