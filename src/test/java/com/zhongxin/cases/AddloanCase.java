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
    public void test() throws InterruptedException {
        BackstageIndexPage indexPage = new BackstageIndexPage(driver);
        Thread.sleep(5000);
        indexPage.clickLoanManage();
        indexPage.clickAddLoan();
        indexPage.inputBorrower("13323234444");
        String title = "借款买房" + System.currentTimeMillis() / 1000;
        indexPage.inputTitle(title);
        indexPage.inputloanRate("10");
        indexPage.inputloanTerm("6");
        indexPage.inputamount("1000000000");
        indexPage.inputbiddingDays("15");
        Thread.sleep(1000);
        //风控评测
        indexPage.clickevaluation();
        indexPage.inputevaluAmount("10");
        Thread.sleep(1000);
        //项目录入
        indexPage.clickprojectInput();
        indexPage.inputhometown("浙江");
        indexPage.inputjob("房地产");
        indexPage.inputage("50");
        Thread.sleep(1000);
        //提交
        indexPage.clickAdddo();

        //第一次审核通过
        indexPage.clickTitleRow(title);
        indexPage.clickCheck();
        indexPage.clickCheckPass();
        //第二次审核通过
        indexPage.clickTitleRow(title);
        indexPage.clickCheck();
        indexPage.clickCheckPass();
        //第三次审核通过
        indexPage.clickTitleRow(title);
        indexPage.clickCheck();
        indexPage.clickCheckPass();

    }
}
