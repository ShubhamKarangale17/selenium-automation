package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class LogoutTestExplicitWait extends BaseTest {

    @Test
    public void logoutTest() {

        // Create Extent report test
        testReport = extent.createTest("Logout Test with Explicit Wait");

        testReport.info("Opening application");
        driver.get("https://www.saucedemo.com");

        // Login
        testReport.info("Logging into application");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Logout
        testReport.info("Logging out from application");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickMenu();
        inventoryPage.clickLogout();

        // Validation
        String currentUrl = driver.getCurrentUrl();

        AssertUtil.assertTrue(
                currentUrl.contains("saucedemo.com"),
                "Logout failed or user not redirected to login page",
                driver,
                "LogoutFailure"
        );

        testReport.pass("Logout functionality validated successfully");
    }
}
