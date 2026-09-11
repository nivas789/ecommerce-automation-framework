package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader config;

    public void setUp() {

        config = new ConfigReader();

        driver = new ChromeDriver();

        driver.get(config.getProperty("url"));

        driver.manage().window().maximize();
    }

    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {

        return driver;
    }
}