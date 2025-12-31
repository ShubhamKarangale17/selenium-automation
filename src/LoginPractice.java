import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPractice {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        // Username → XPath
        driver.findElement(By.xpath("//input[@id='user-name']"))
              .sendKeys("standard_user");

        // Password → CSS Selector
        driver.findElement(By.cssSelector("input[id='password']"))
              .sendKeys("secret_sauce");

        // Login button → XPath
        driver.findElement(By.xpath("//input[@id='login-button']"))
              .click();

        driver.quit();
    }
}
