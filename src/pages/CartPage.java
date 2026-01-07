package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By cartItems = By.className("cart_item");
    By productName = By.className("inventory_item_name");
    By removeBtn = By.xpath("//button[contains(text(),'Remove')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Check if product present in cart
    public boolean isProductPresentInCart() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size() > 0;
    }

    // ✅ Get product name from cart
    public String getProductNameFromCart() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(productName)
            ).getText();
        } catch (Exception e) {
            return null;
        }
    }

    // Existing methods (keep)
    public boolean isCartNotEmpty() {
        return isProductPresentInCart();
    }

    public void removeProductFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItems).size() == 0;
    }
}

