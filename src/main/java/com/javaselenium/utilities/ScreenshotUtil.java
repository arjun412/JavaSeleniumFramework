package com.javaselenium.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") + "/reports/screenshots/" + name + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File(dest);
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(src, destFile);
            return dest;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
