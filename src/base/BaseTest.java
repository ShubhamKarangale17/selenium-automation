package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest testReport;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\WebDrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Navigate ONLY from BaseTest
        driver.get("https://www.saucedemo.com");

        // ✅ Initialize Extent only once
        if (extent == null) {
            extent = ExtentManager.getExtentReport();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // Safety check
        if (testReport != null) {

            if (result.getStatus() == ITestResult.FAILURE) {

                String testName = result.getName();

                // Take screenshot
                ScreenshotUtil.takeScreenshot(driver, testName);

                testReport.log(Status.FAIL,
                        "Test Failed: " + result.getThrowable());

                testReport.addScreenCaptureFromPath(
                        "screenshots/" + testName + ".png");
            }

            else if (result.getStatus() == ITestResult.SUCCESS) {
                testReport.log(Status.PASS, "Test Passed");
            }

            else if (result.getStatus() == ITestResult.SKIP) {
                testReport.log(Status.SKIP, "Test Skipped");
            }
        }

        // Close browser
        if (driver != null) {
            driver.quit();
        }

        // Flush report
        if (extent != null) {
            extent.flush();
        }
    }
}

