package com.praktikum.testing.otomation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String screenshotDir = System.getProperty("user.dir")
                    + File.separator + "test-output"
                    + File.separator + "screenshots";

            String fileName = screenshotName + "_" + timestamp + ".png";

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotDir, fileName);

            FileUtils.forceMkdirParent(destination);
            FileUtils.copyFile(source, destination);

            // 🔥 RETURN RELATIVE PATH (INI PENTING)
            return "screenshots/" + fileName;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
