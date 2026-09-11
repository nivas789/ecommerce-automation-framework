package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.TestDataProvider;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    @Test(
        dataProvider = "loginData",
        dataProviderClass = TestDataProvider.class,
        groups = "regression"
    )
    public void loginTest(
            String username,
            String password,
            String expectedResult) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        WaitUtils waitUtils = new WaitUtils(driver);

        if (expectedResult.equalsIgnoreCase("success")) {

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("inventory"),
                    "User was not redirected to the inventory page"
            );

            System.out.println(
                    "Login successful for user: " + username
            );

        } else {

            By errorMessage =
                    By.cssSelector("[data-test='error']");

            String actualErrorMessage =
                    waitUtils
                            .waitForVisibility(errorMessage)
                            .getText();

            Assert.assertTrue(
                    actualErrorMessage.contains("Username and password")
                            || actualErrorMessage.contains("locked out"),
                    "Expected login error message was not displayed"
            );

            System.out.println(
                    "Login failed as expected for user: "
                            + username
            );
        }
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }
}