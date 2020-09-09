package com.zhongxin.day05;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SpecialElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = open("chrome");
//        driver.get("https://www.fliggy.com/?ttid=seo.000000574&seoType=origin");
//        WebElement element = driver.findElement(By.xpath("//div[@class='search-field']//div[@class='calendar-input-wrap']//input[@placeholder='yyyy-mm-dd']"));
//        element.sendKeys("aaa");

//        driver.get("https://www.12306.cn/index/");
//        driver.findElement(By.id("train_date")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@class='cal']//div[8]")).click();

//        driver.get("https://www.12306.cn/index/");
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("document.getElementById('train_date').removeAttribute('readonly')");
//        WebElement train_date = driver.findElement(By.id("train_date"));
//        train_date.clear();
//        Thread.sleep(1000);
//        train_date.sendKeys("2020-11-11");
//        Thread.sleep(3000);

//        driver.get("https://www.12306.cn/index/");
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        WebElement train_date = driver.findElement(By.id("train_date"));
//        jsExecutor.executeScript("arguments[0].removeAttribute('readonly')", train_date);
//        jsExecutor.executeScript("arguments[0].removeAttribute(arguments[1])", train_date, "readonly");


//        driver.get("src/test/resources/file.html");
//        driver.findElement(By.id("file")).sendKeys("aaa");



        close(driver);
    }


    public static void close(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static WebDriver open(String type) {
        WebDriver driver = null;
        if ("chrome".equalsIgnoreCase(type)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();
        } else if ("ie".equalsIgnoreCase(type)) {
            // 设置ie启动项
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // 忽略缩放
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            // 忽略保护模式
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            // 设置初始化浏览器地址
            capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://www.baidu.com");
            // 配置ie驱动位置
            System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
            // 创建ie驱动对象
            driver = new InternetExplorerDriver();
        } else if ("firefox".equalsIgnoreCase(type)) {
            System.setProperty("webdriver.firefox.bin", "D:\\Mozilla Firefox\\firefox.exe");
            System.setProperty("webdriver.firefox.driver", "src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
