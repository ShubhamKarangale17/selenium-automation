package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By cartItem = By.className("cart_item");
    By cartItemName = By.className("inventory_item_name");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Check if cart has at least one product
    public boolean isProductPresentInCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem))
                   .isDisplayed();
    }

    // Get product name from cart
    public String getProductNameFromCart() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartItemName))
                .getText();
    }
}
