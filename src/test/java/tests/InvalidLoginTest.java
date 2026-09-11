package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.WaitUtils;

public class InvalidLoginTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    @Test(groups = "regression")
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "invalid_user",
                "wrong_password"
        );

        WaitUtils waitUtils = new WaitUtils(driver);

        By errorMessage = By.cssSelector("[data-test='error']");

        String actualErrorMessage =
                waitUtils
                        .waitForVisibility(errorMessage)
                        .getText();

        System.out.println("Error Message: " + actualErrorMessage);

        Assert.assertTrue(
                actualErrorMessage.contains("Username and password do not match"),
                "Expected invalid login error message was not displayed"
        );
    }

    @Test(groups = "regression")
    public void lockedUserLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "locked_out_user",
                "secret_sauce"
        );

        WaitUtils waitUtils = new WaitUtils(driver);

        By errorMessage = By.cssSelector("[data-test='error']");

        String actualErrorMessage =
                waitUtils
                        .waitForVisibility(errorMessage)
                        .getText();

        System.out.println("Locked User Error: " + actualErrorMessage);

        Assert.assertTrue(
                actualErrorMessage.contains("locked out"),
                "Expected locked user error message was not displayed"
        );
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }
}