package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");

    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    private By orderConfirmation = By.className("complete-header");

    // Element available on checkout overview page
    private By overviewTitle = By.className("title");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterFirstName(String firstName) {

        waitUtils
                .waitForVisibility(firstNameField)
                .sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        waitUtils
                .waitForVisibility(lastNameField)
                .sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {

        waitUtils
                .waitForVisibility(postalCodeField)
                .sendKeys(postalCode);
    }

    public void clickContinue() {

        waitUtils
                .waitForClickable(continueButton)
                .click();

        // Wait for checkout overview page
        waitUtils
                .waitForVisibility(overviewTitle);
    }

    public void clickFinish() {

        waitUtils
                .waitForVisibility(finishButton)
                .click();
    }

    public void enterCustomerDetails(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue();
    }

    public boolean isOrderConfirmed() {

        return waitUtils
                .waitForVisibility(orderConfirmation)
                .isDisplayed();
    }
}