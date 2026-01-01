package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    // Locators
    By menuButton = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}
