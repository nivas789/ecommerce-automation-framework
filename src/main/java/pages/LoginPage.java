package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterUsername(String username) {
        waitUtils.waitForVisibility(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passwordField)
                .sendKeys(password);
    }

    public void clickLogin() {
        waitUtils.waitForClickable(loginButton)
                .click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}