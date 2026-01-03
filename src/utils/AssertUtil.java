package utils;

import org.openqa.selenium.WebDriver;

public class AssertUtil {

    public static void assertTrue(boolean condition,
                                  String message,
                                  WebDriver driver,
                                  String screenshotName) {

        if (!condition) {
            System.out.println("ASSERTION FAILED: " + message);
            ScreenshotUtil.takeScreenshot(driver, screenshotName);
            throw new RuntimeException("TEST FAILED: " + message);
        } else {
            System.out.println("ASSERTION PASSED");
        }
    }
}
