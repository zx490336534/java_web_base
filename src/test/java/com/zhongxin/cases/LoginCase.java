package com.zhongxin.cases;

import com.zhongxin.pages.LoginPage;
import okio.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginCase {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        //打开浏览器
        driver = open("chrome");
        //访问登陆页面
        driver.get("http://120.78.128.25:8765/Index/login.html");
    }

    @Test
    public void test() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone("13212312312");
        loginpage.inputPassword("123123123");
        loginpage.clickLoginBtn();
        Thread.sleep(2000);
        String actual = loginpage.getCenterErrorText();
        String expected = "此账号没有经过授权，请联系管理员!";
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //关闭浏览器
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
