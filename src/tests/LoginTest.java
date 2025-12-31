package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    @Test
    public void validLoginTest() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("inventory"),
                "Login failed!");

        driver.quit();
    }
}
