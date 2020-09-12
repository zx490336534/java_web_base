package com.zhongxin.cases;

import com.zhongxin.common.BaseCase;
import com.zhongxin.common.Constants;
import com.zhongxin.pages.BackstageIndexPage;
import com.zhongxin.pages.BackstageLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddloanCase extends BaseCase {
    private WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriver driver = open(Constants.BROWSER_TYPE);
        driver.get(Constants.BACKSTAGE_URL);
        BackstageLoginPage loginPage = new BackstageLoginPage(driver);
        loginPage.inputUsername(Constants.ADMIN_USEARNAME);
        loginPage.inputPassword(Constants.ADMIN_PASSWORD);
        loginPage.inputCode("hapi");
        loginPage.clickLoginBtn();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        close(driver);
    }


    @Test
    public void test() {
        BackstageIndexPage indexPage = new BackstageIndexPage(driver);
        indexPage.clickLoanManage();
        indexPage.clickAddLoan();
        indexPage.inputBorrower("13323234444");
    }
}
