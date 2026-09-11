package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By productsTitle = By.className("title");
    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isProductsPageDisplayed() {
        return waitUtils
                .waitForVisibility(productsTitle)
                .isDisplayed();
    }

    public void addBackpackToCart() {
        waitUtils
                .waitForClickable(backpack)
                .click();
    }

    public void clickCart() {
        waitUtils
                .waitForClickable(cartIcon)
                .click();
    }
}