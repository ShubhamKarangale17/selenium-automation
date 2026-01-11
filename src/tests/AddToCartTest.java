package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.AssertUtil;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        // Create Extent Report test
        testReport = extent.createTest("Add To Cart Test");

        testReport.info("Opening application");
        driver.get("https://www.saucedemo.com");

        // Login
        testReport.info("Logging into Application");
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        // Add product to cart
        testReport.info("Adding first product to cart");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstProductToCart();

        int cartCount = inventory.getCartCount();

        // Validation
        AssertUtil.assertTrue(
                cartCount == 1,
                "Product not added to cart",
                driver,
                "AddToCartFailure"
        );

        testReport.pass("Product successfully added to cart");
    }
}

