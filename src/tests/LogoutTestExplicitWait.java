package tests;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class LogoutTestExplicitWait extends BaseTest {

    public static void main(String[] args) {

        LogoutTest test = new LogoutTest();
        test.setUp();

        test.driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(test.driver);
        inventoryPage.clickMenu();
        inventoryPage.clickLogout();

        String currentUrl = test.driver.getCurrentUrl();

        if (currentUrl.contains("saucedemo.com")) {
            System.out.println("LOGOUT TEST PASSED");
        } else {
            System.out.println("LOGOUT TEST FAILED");
        }

        test.tearDown();
    }
}
