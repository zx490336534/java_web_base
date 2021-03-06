package com.zhongxin.cases;

import com.zhongxin.common.BaseCase;
import com.zhongxin.common.Constants;
import com.zhongxin.listeners.MyRetry;
import com.zhongxin.pages.IndexPage;
import com.zhongxin.pages.LoginPage;
import org.openqa.selenium.WebDriver;
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

    @Test(retryAnalyzer = MyRetry.class)
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


}
