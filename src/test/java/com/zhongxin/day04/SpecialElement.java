package com.zhongxin.day04;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        close(driver);
    }

    public static void myiframe(WebDriver driver) throws InterruptedException {
        driver.get("/Users/zhongxin/IdeaProjects/web_base/src/test/resources/testpage/iframe/a.html");
        driver.findElement(By.id("aa")).sendKeys("a");
        //切换iframe
        driver.switchTo().frame(1);
        driver.findElement(By.id("bb")).sendKeys("b");
        //切换iframe
        driver.switchTo().frame("cframe");
        driver.findElement(By.id("cc")).sendKeys("c");
        //切换父iframe
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        //切换到最外层iframe
        driver.switchTo().defaultContent();
        WebElement bframeElement = driver.findElement(By.id("bframe"));
        //切换到bframe
        driver.switchTo().frame(bframeElement);
        driver.findElement(By.id("bb")).sendKeys("bbbbb");
    }

    public static void mywindow(WebDriver driver) {
        driver.get("/Users/zhongxin/IdeaProjects/web_base/src/test/resources/testpage/window/a.html");
        //获取当前窗口的句柄
        String aHandle = driver.getWindowHandle();
        System.out.println("aHandle:" + aHandle);

        driver.findElement(By.linkText("跳到b页面")).click();
        driver.findElement(By.linkText("跳到c页面")).click();
        Set<String> handles2 = driver.getWindowHandles();
        List<String> list = new ArrayList(handles2);
        aHandle = list.get(0);
        String bHandle = list.get(1);
        String cHandle = list.get(2);
        System.out.println("aHandle:" + aHandle);
        System.out.println("bHandle:" + bHandle);
        System.out.println("cHandle:" + cHandle);
        //切换到b窗口
        driver.switchTo().window(bHandle);
        //切换到c窗口
        driver.switchTo().window(cHandle);

        //切换到a窗口
        driver.switchTo().window(aHandle);
    }

    public static void myalart(WebDriver driver) throws InterruptedException {
        driver.get("/Users/zhongxin/IdeaProjects/web_base/src/test/resources/testpage/alert/alert_confirm.html");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(1000);
        alert.accept();
        alert.dismiss();
        System.out.println(alert.getText());
        Thread.sleep(1000);
        alert.accept();
    }

    public static void myselect(WebDriver driver) throws InterruptedException {
        WebElement selectElement = driver.findElement(By.id("modules"));
        Select select = new Select(selectElement);
        List<WebElement> options = select.getOptions();
        System.out.println(options);
        System.out.println(select.isMultiple());
        select.selectByIndex(1);
        Thread.sleep(200);
        select.selectByValue("20");
        Thread.sleep(2000);
        select.selectByVisibleText("switch");
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
