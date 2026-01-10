package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void removeFromCartTest() {

        // Create Extent test
        testReport = extent.createTest("Remove From Cart Test");

        testReport.info("Opening Application");
        driver.get("https://www.saucedemo.com");

        // Login
        testReport.info("Logging into application");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product & open cart
        testReport.info("Adding product to cart");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstProductToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        // Validate cart not empty
        testReport.info("Validating cart is not empty");
        AssertUtil.assertTrue(
                cartPage.isCartNotEmpty(),
                "Cart is empty before removal",
                driver,
                "CartEmptyBeforeRemove"
        );

        // Remove product
        testReport.info("Removing product from cart");
        cartPage.removeProductFromCart();

        // Validate cart empty
        testReport.info("Validating cart is empty after removal");
        AssertUtil.assertTrue(
                cartPage.isCartEmpty(),
                "Cart not empty after removal",
                driver,
                "CartNotEmptyAfterRemove"
        );

        testReport.pass("Remove from cart functionality validated successfully");
    }
}
