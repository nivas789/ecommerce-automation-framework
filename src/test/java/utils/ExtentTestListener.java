package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extentReports;

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        extentReports =
                ExtentReportManager.getReportInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extentReports.createTest(
                        result.getMethod().getMethodName()
                );

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest
                .get()
                .pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest
                .get()
                .fail("Test Failed");

        extentTest
                .get()
                .fail(result.getThrowable());

        try {

            BaseTest testInstance =
                    (BaseTest) result.getInstance();

            WebDriver driver =
                    testInstance.getDriver();

            if (driver != null) {

                String screenshotPath =
                        ScreenshotUtils.captureScreenshot(
                                driver,
                                result.getMethod().getMethodName()
                        );

                extentTest
                        .get()
                        .addScreenCaptureFromPath(
                                screenshotPath
                        );
            }

        } catch (Exception e) {

            extentTest
                    .get()
                    .warning(
                            "Screenshot could not be attached: "
                            + e.getMessage()
                    );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest
                .get()
                .skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();
    }
}