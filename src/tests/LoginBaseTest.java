package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginBaseTest extends BaseTest {

    @Test
    public void validLoginTest() {

        // Create Extent report entry
        testReport = extent.createTest("Valid Login Test");

        testReport.info("Logging into application with valid credentials");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        boolean isLoginSuccessful =
                driver.getCurrentUrl().contains("inventory");

        // Assertion
        Assert.assertTrue(isLoginSuccessful, "Login failed!");

        testReport.pass("User logged in successfully and landed The on inventory page");
    }
}
