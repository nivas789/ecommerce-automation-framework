package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.StaleElementReferenceException;

import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By backpack = By.id("item_4_title_link");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isBackpackDisplayed() {

        try {
            return waitUtils
                    .waitForVisibility(backpack)
                    .isDisplayed();

        } catch (StaleElementReferenceException e) {

            return waitUtils
                    .waitForVisibility(backpack)
                    .isDisplayed();
        }
    }

    public void clickCheckout() {

        waitUtils
                .waitForClickable(checkoutButton)
                .click();
    }
}