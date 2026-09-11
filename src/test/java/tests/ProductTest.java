package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class ProductTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        setUp();
    }

    @Test(groups = "smoke")
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isProductsPageDisplayed(),
                "Products page is not displayed"
        );

        homePage.addBackpackToCart();

        homePage.clickCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isBackpackDisplayed(),
                "Backpack was not added to cart"
        );
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        tearDown();
    }
}