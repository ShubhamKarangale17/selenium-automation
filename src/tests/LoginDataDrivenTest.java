package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.AssertUtil;

public class LoginDataDrivenTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"standard_user", "secret_sauce", "valid"},
                {"locked_out_user", "secret_sauce", "locked"},
                {"wrong_user", "wrong_pass", "invalid"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginDataDrivenTest(String username,
                                    String password,
                                    String type) {

        // Extent report entry
        testReport = extent.createTest(
                "Login Data Driven Test - User: " + username);

        testReport.info("Opening application");
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);

        testReport.info("Entering credentials");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();

        if (type.equals("valid")) {

            AssertUtil.assertTrue(
                    currentUrl.contains("inventory"),
                    "Valid user failed to login",
                    driver,
                    "ValidLoginFailure"
            );

            testReport.pass("Valid login successful");

        } else {

            AssertUtil.assertTrue(
                    currentUrl.contains("saucedemo"),
                    "Invalid/Locked user login behavior incorrect",
                    driver,
                    "NegativeLoginFailure"
            );

            testReport.pass("Negative login validated successfully");
        }
    }
}
