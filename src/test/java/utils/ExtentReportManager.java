package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            String reportPath =
                    System.getProperty("user.dir")
                    + "/reports/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config()
                    .setDocumentTitle("E-Commerce Automation Test Report");

            sparkReporter.config()
                    .setReportName("Automation Test Execution Report");

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo(
                    "Project",
                    "E-Commerce Web Application"
            );

            extentReports.setSystemInfo(
                    "Automation Tool",
                    "Selenium WebDriver"
            );

            extentReports.setSystemInfo(
                    "Testing Framework",
                    "TestNG"
            );

            extentReports.setSystemInfo(
                    "Language",
                    "Java"
            );
        }

        return extentReports;
    }
}