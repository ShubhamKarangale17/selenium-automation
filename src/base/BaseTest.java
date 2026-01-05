package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest testReport;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\WebDrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize Extent Report
        extent = ExtentManager.getExtentReport();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // If test fails → take screenshot + log failure
        if (result.getStatus() == ITestResult.FAILURE) {

            String testName = result.getName();
            ScreenshotUtil.takeScreenshot(driver, testName);

            testReport.log(Status.FAIL,
                    "Test Failed: " + result.getThrowable());

            testReport.addScreenCaptureFromPath(
                    "screenshots/" + testName + ".png");
        }

        // If test passes
        else if (result.getStatus() == ITestResult.SUCCESS) {
            testReport.log(Status.PASS, "Test Passed");
        }

        // Close browser
        if (driver != null) {
            driver.quit();
        }

        // Flush report
        extent.flush();
    }
}
