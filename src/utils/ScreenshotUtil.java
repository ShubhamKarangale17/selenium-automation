package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/" + testName + ".png");

            Files.copy(src, dest);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
