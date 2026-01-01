package tests;

import base.BaseTest;
import pages.LoginPage;

public class LoginDataDrivenTest extends BaseTest {

    public static void main(String[] args) {

        LoginDataDrivenTest test = new LoginDataDrivenTest();

        // Test data (username, password)
        String[][] loginData = {
            {"standard_user", "secret_sauce"},   // valid
            {"locked_out_user", "secret_sauce"}, // locked
            {"wrong_user", "wrong_pass"}         // invalid
        };

        for (int i = 0; i < loginData.length; i++) {

            System.out.println("Running test for user: " + loginData[i][0]);

            test.setUp();
            test.driver.get("https://www.saucedemo.com");

            LoginPage loginPage = new LoginPage(test.driver);
            loginPage.enterUsername(loginData[i][0]);
            loginPage.enterPassword(loginData[i][1]);
            loginPage.clickLogin();

            String currentUrl = test.driver.getCurrentUrl();

            if (loginData[i][0].equals("standard_user")
                    && currentUrl.contains("inventory")) {
                System.out.println("TEST PASSED\n");
            } else if (!loginData[i][0].equals("standard_user")
                    && currentUrl.contains("saucedemo")) {
                System.out.println("NEGATIVE TEST PASSED\n");
            } else {
                System.out.println("TEST FAILED\n");
            }

            test.tearDown();
        }
    }
}
