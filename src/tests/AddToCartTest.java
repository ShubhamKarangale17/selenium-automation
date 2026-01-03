package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;

public class AddToCartTest extends BaseTest {

    public static void main(String[] args) {

        AddToCartTest test = new AddToCartTest();
        test.setUp();

        test.driver.get("https://www.saucedemo.com");

        LoginPage login = new LoginPage(test.driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        InventoryPage inventory = new InventoryPage(test.driver);
        inventory.addFirstProductToCart();

        int cartCount = inventory.getCartCount();

        if (cartCount == 1) {
            System.out.println("ADD TO CART TEST PASSED");
        } else {
            System.out.println("ADD TO CART TEST FAILED");
        }

        test.tearDown();
    }
}
