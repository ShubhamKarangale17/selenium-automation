package tests;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class RemoveFromCartTest extends BaseTest {

    public static void main(String[] args) {

        RemoveFromCartTest test = new RemoveFromCartTest();
        test.setUp();

        test.driver.get("https://www.saucedemo.com");

        // Login
        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product
        InventoryPage inventoryPage = new InventoryPage(test.driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        // Cart page
        CartPage cartPage = new CartPage(test.driver);

        // Verify cart is not empty
        AssertUtil.assertTrue(
                cartPage.isCartNotEmpty(),
                "Cart is empty before removal",
                test.driver,
                "CartEmptyBeforeRemove"
        );

        // Remove item
        cartPage.removeProductFromCart();

        // Verify cart is empty
        AssertUtil.assertTrue(
                cartPage.isCartEmpty(),
                "Cart not empty after removal",
                test.driver,
                "CartNotEmptyAfterRemove"
        );

        System.out.println("REMOVE FROM CART TEST PASSED");

        test.tearDown();
    }
}
