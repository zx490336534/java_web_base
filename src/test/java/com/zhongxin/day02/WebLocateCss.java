package com.zhongxin.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebLocateCss {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = open("chrome");
        driver.get("https://www.baidu.com");

        By.xpath("*[@name='phone']");
        By.xpath("//*[text()='忘记密码?']");
        By.xpath("//*[contains(@name,'one')]");
        By.xpath("//*[contains(text(),'忘记密码')]");

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
