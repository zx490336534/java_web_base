package com.zhongxin.cases;

import com.zhongxin.common.BaseCase;
import com.zhongxin.common.Constants;
import com.zhongxin.pages.IndexPage;
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
import org.testng.annotations.*;


public class LoginCase extends BaseCase {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        //打开浏览器
        driver = open(Constants.BROWSER_TYPE);
    }

    @BeforeMethod
    public void setUpMethod() {
        //访问登陆页面
        driver.get(Constants.LOGIN_URL);
    }

    @Test
    public void testFailed01() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone("13212312312");
        loginpage.inputPassword("123123123");
        loginpage.clickLoginBtn();
        String actual = loginpage.getCenterErrorText();
        String expected = "此账号没有经过授权，请联系管理员!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFailed02() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone("");
        loginpage.inputPassword("123123123");
        loginpage.clickLoginBtn();
        String actual = loginpage.getPhoneFormErrorText();
        String expected = "请输入手机号";
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "datas")
    public void testFailed03(String phone, String password, String expected) throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone(phone);
        loginpage.inputPassword(password);
        loginpage.clickLoginBtn();
        String actual = loginpage.getPhoneFormErrorText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFailed04() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone("15859019251");
        loginpage.inputPassword("");
        loginpage.clickLoginBtn();
        String actual = loginpage.getPasswordFormErrorText();
        Assert.assertEquals(actual, "请输入密码");
    }

    @Test
    public void testFailed05() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone("13323234545");
        loginpage.inputPassword("123123123");
        loginpage.clickLoginBtn();
        String actual = loginpage.getCenterErrorText();
        Assert.assertEquals(actual, "帐号或密码错误!");
    }

    @Test(priority = 1)
    public void testSuccess() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone("13323234545");
        loginpage.inputPassword("lemon123456");
        loginpage.clickLoginBtn();
        Thread.sleep(2000);
        IndexPage indexPage = new IndexPage(driver);
        boolean flag = indexPage.nicknameIsVisibility();
        Assert.assertTrue(flag);

    }

    @Test
    public void testSuccess02() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.inputPhone("13323234545");
        loginpage.inputPassword("lemon123456");
        loginpage.CheckRememberMe();
        loginpage.clickLoginBtn();
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickLogout();
        indexPage.clickLogin();
        String actual = loginpage.getPhoneValue();
        Assert.assertEquals(actual, "13323234545");
    }

    @DataProvider
    public Object[][] datas() {
        Object[][] datas = {
                {"", "123123123", "请输入手机号"},
                {"1585901925", "123123123", "请输入正确的手机号"},
                {"158590192534", "123123123", "请输入正确的手机号"},
                {"1585901925%", "123123123", "请输入正确的手机号"},
        };
        return datas;
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
