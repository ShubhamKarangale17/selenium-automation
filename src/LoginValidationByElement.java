import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidationByElement {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");

        // Login
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

        // VALIDATION
       /* String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("LOGIN TEST PASSED");
        } else {
            System.out.println("LOGIN TEST FAILED");
        }*/
        
        String pageText = driver.findElement(By.className("title")).getText();

        if (pageText.equals("Products")) {
            System.out.println("LOGIN SUCCESSFUL - PRODUCTS PAGE DISPLAYED");
        } else {
            System.out.println("LOGIN FAILED");
        }


        //driver.quit();
    }
}