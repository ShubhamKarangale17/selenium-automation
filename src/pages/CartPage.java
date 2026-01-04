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
    By removeBtn = By.xpath("//button[contains(text(),'Remove')]");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Check if cart has items
    public boolean isCartNotEmpty() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size() > 0;
    }

    // Remove product from cart page
    public void removeProductFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
    }

    // Check if cart is empty
    public boolean isCartEmpty() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size() == 0;
    }
}
