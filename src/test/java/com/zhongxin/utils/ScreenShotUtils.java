package com.zhongxin.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * 截图
 */
public class ScreenShotUtils {
    /**
     * 截图并保存到指定位置
     *
     * @param driver       浏览器驱动
     * @param destFileName 截图保存的文件名
     */
    public static void screenShot(WebDriver driver, String destFileName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(file.getAbsoluteFile());
        File destFile = new File("src/test/resources/" + destFileName);
        try {
            // 移动文件
            FileUtils.moveFile(file, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
