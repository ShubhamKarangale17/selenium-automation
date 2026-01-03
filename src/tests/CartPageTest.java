package tests;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class CartPageTest extends BaseTest {

    public static void main(String[] args) {

        CartPageTest test = new CartPageTest();
        test.setUp();

        test.driver.get("https://www.saucedemo.com");

        // Login
        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product to cart
        InventoryPage inventoryPage = new InventoryPage(test.driver);
        inventoryPage.addFirstProductToCart();

        // Open cart
        inventoryPage.openCart();

        // Cart validation
        CartPage cartPage = new CartPage(test.driver);

        boolean isItemPresent = cartPage.isProductPresentInCart();
        String productName = cartPage.getProductNameFromCart();

        AssertUtil.assertTrue(
                isItemPresent,
                "Product not present in cart",
                test.driver,
                "CartEmptyFailure"
        );

        AssertUtil.assertTrue(
                productName != null && !productName.isEmpty(),
                "Product name not visible in cart",
                test.driver,
                "CartProductNameFailure"
        );

        System.out.println("CART PAGE VALIDATION TEST PASSED");

        test.tearDown();
    }
}
