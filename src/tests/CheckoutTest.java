package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutFlowTest() {

        // Create Extent test
        testReport = extent.createTest("Checkout Flow Test");

        testReport.info("Opening application");
        driver.get("https://www.saucedemo.com");

        // Login
        testReport.info("Logging into application");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product & go to cart
        testReport.info("Adding product to cart");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        // Checkout
        testReport.info("Starting checkout");
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();

        testReport.info("Entering checkout details");
        checkoutPage.enterCheckoutDetails("Shubham", "Karangale", "411001");
        checkoutPage.clickContinue();

        // Finish order
        testReport.info("Finishing order");
        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();

        // Validation
        String successMessage = overviewPage.getSuccessMessage();

        AssertUtil.assertTrue(
                successMessage.contains("Thank you for your order"),
                "Checkout failed or success message not shown",
                driver,
                "CheckoutFailure."
        );

        testReport.pass("Checkout flow completed successfully");
    }
}
