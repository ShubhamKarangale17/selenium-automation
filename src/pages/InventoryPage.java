package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    WebDriver driver;
    WebDriverWait wait;

    // ===== LOCATORS =====

    // Menu & Logout
    By menuButton = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    // Products
    By firstAddToCartBtn =
            By.xpath("(//button[contains(text(),'Add to cart')])[1]");

    // Cart
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    // ===== CONSTRUCTOR =====
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== ACTION METHODS =====

    // Open menu
    public void clickMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
    }

    // Logout
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    // Add first product to cart
    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartBtn))
            .click();
    }

    // Get cart count (badge value)
    public int getCartCount() {
        try {
            String count =
                wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge))
                    .getText();
            return Integer.parseInt(count);
        } catch (Exception e) {
            return 0; // cart empty
        }
    }

    // Click cart icon
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
}
