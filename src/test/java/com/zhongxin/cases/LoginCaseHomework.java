package com.zhongxin.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


public class LoginCaseHomework {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        //1.打开浏览器
        driver = open("chrome");
        //2.访问登陆页面
        driver.get("http://120.78.128.25:8765/Index/login.html");
    }

    @Test
    public void test() throws InterruptedException {
        //3.输入用户名
        driver.findElement(By.name("phone")).sendKeys("15859019266");
        //4.输入密码
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        //5.点击登陆按钮
        driver.findElement(By.xpath("//button[@class='btn btn-special']")).click();
        Thread.sleep(2000);
        //6.断言
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'我的帐户[自动化测试帐号1]')]")));
            boolean displayed = until.isDisplayed();
            if (displayed) {
                System.out.println("用户已注册");
            }
            Assert.assertTrue(displayed);
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("用户未注册");
            Assert.assertTrue(false);
        }

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        //6.关闭浏览器
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
