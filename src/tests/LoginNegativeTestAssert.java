package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.AssertUtil;

public class LoginNegativeTestAssert extends BaseTest {

    @Test
    public void negativeLoginAssertTest() {

        // Create Extent report entry
        testReport = extent.createTest("Negative Login Test using AssertUtil");

        testReport.info("Opening Application");
        driver.get("https://www.saucedemo.com");

        // Login with invalid credentials
        testReport.info("Entering invalid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        // Validation
        testReport.info("Validating error message");
        String errorText = loginPage.getErrorMessage();

        boolean isErrorCorrect =
                errorText.contains("Username and password do not match");

        AssertUtil.assertTrue(
                isErrorCorrect,
                "Error message is incorrect or not displayed",
                driver,
                "NegativeLoginAssertionFailure"
        );

        testReport.pass("Negative login assertion validated successfully");
    }
}
