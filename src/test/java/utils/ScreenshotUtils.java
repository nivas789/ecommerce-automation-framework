package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String screenshotDirectory =
                System.getProperty("user.dir")
                + "/reports/screenshots/";

        File directory =
                new File(screenshotDirectory);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String screenshotPath =
                screenshotDirectory
                + testName
                + "_" + System.currentTimeMillis()
                + ".png";

        File sourceFile =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File destinationFile =
                new File(screenshotPath);

        try {

            Files.copy(
                    sourceFile.toPath(),
                    destinationFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {

            e.printStackTrace();
        }

        return screenshotPath;
    }
}