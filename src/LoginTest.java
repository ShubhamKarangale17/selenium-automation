import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        // Username
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        // Password
        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        // Login button
        driver.findElement(By.id("login-button"))
              .click();

        // Close browser
        driver.quit();
    }
}
