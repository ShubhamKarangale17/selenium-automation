package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginTestDataDriven extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {
            {"standard_user", "secret_sauce"},   // valid
            {"locked_out_user", "secret_sauce"}, // locked user
            {"invalid_user", "wrong_pass"}       // invalid
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        String currentUrl = driver.getCurrentUrl();

        if (username.equals("standard_user")) {
            Assert.assertTrue(currentUrl.contains("inventory"),
                    "Valid login failed");
        } else {
            Assert.assertTrue(currentUrl.contains("saucedemo"),
                    "Invalid login test failed");
        }
    }
}
