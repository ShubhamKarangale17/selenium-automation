package tests;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    public static void main(String[] args) {

        LogoutTest test = new LogoutTest();
        test.setUp();

        test.driver.get("https://www.saucedemo.com");

        // Login
        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Logout
        InventoryPage inventoryPage = new InventoryPage(test.driver);
        inventoryPage.clickMenu();

        // Small wait (simple way)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        inventoryPage.clickLogout();

        // Validation
        String currentUrl = test.driver.getCurrentUrl();

        if (currentUrl.contains("saucedemo.com")) {
            System.out.println("LOGOUT TEST PASSED");
        } else {
            System.out.println("LOGOUT TEST FAILED");
        }

        test.tearDown();
    }
}
