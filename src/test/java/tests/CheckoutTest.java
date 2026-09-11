package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    @Test(groups = "smoke")
    public void completeCheckoutTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        HomePage homePage = new HomePage(driver);

        homePage.addBackpackToCart();
        homePage.clickCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isBackpackDisplayed(),
                "Backpack is not present in cart"
        );

        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterCustomerDetails(
                "Srinivas",
                "Test",
                "534101"
        );

        checkoutPage.clickFinish();

        Assert.assertTrue(
                checkoutPage.isOrderConfirmed(),
                "Order confirmation was not displayed"
        );
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }
}