package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class CartPageTest extends BaseTest {

    @Test
    public void cartPageValidationTest() {

        // Create Extent report entry
        testReport = extent.createTest("Cart Page Validation Test");

        testReport.info("Logging into application");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product to cart
        testReport.info("Adding first product to cart");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstProductToCart();

        // Open cart
        testReport.info("Opening cart page");
        inventoryPage.openCart();

        // Cart validation
        CartPage cartPage = new CartPage(driver);

        boolean isItemPresent = cartPage.isProductPresentInCart();
        String productName = cartPage.getProductNameFromCart();

        AssertUtil.assertTrue(
                isItemPresent,
                "Product not present in cart",
                driver,
                "CartEmptyFailure"
        );

        AssertUtil.assertTrue(
                productName != null && !productName.isEmpty(),
                "Product name not visible in cart",
                driver,
                "CartProductNameFailure"
        );

        testReport.pass("Cart page validation completed successfully");
    }
}
