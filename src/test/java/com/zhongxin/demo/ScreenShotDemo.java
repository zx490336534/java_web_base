package com.zhongxin.demo;

import com.zhongxin.common.BaseCase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShotDemo extends BaseCase {
    @Test
    public void test() throws Exception {
        WebDriver driver = open("chrome");
        driver.get("htts://www.baidu.com");
        Thread.sleep(2000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(file.getAbsoluteFile());
        File destFile = new File("aaa.png");
        FileUtils.moveFile(file, destFile);
        close(driver);
    }
}
