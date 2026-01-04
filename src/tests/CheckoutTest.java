package tests;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class CheckoutTest extends BaseTest {

    public static void main(String[] args) {

        CheckoutTest test = new CheckoutTest();
        test.setUp();

        test.driver.get("https://www.saucedemo.com");

        // Login
        LoginPage loginPage = new LoginPage(test.driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product & go to cart
        InventoryPage inventoryPage = new InventoryPage(test.driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        // Checkout
        CartPage cartPage = new CartPage(test.driver);
        CheckoutPage checkoutPage = new CheckoutPage(test.driver);
        checkoutPage.clickCheckout();

        checkoutPage.enterCheckoutDetails("Shubham", "Karangale", "411001");
        checkoutPage.clickContinue();

        // Finish order
        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(test.driver);
        overviewPage.clickFinish();

        // Validation
        String successMessage = overviewPage.getSuccessMessage();

        AssertUtil.assertTrue(
                successMessage.contains("Thank you for your order"),
                "Checkout failed or success message not shown",
                test.driver,
                "CheckoutFailure"
        );

        System.out.println("CHECKOUT FLOW TEST PASSED");

        test.tearDown();
    }
}
