package com.zhongxin.cases;

import com.sun.prism.PresentableState;
import com.zhongxin.common.BaseCase;
import com.zhongxin.common.BasePage;
import com.zhongxin.common.Constants;
import com.zhongxin.pages.*;
import com.zhongxin.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class InvestCase extends BaseCase {
    public WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriver driver = open(Constants.BROWSER_TYPE);
        driver.get(Constants.LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPhone(Constants.INVEST_USERNAME);
        loginPage.inputPassword(Constants.INVEST_PASSWORD);
        loginPage.clickLoginBtn();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        close(driver);
    }

    @Test
    public void test() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickBidding("借款买地1600142374");

        LoanDetailPage loanDetailPage = new LoanDetailPage(driver);

        String beforeText = loanDetailPage.getsurplusText();
        String amount = "100";
        loanDetailPage.inputInvestAmount(amount);
        loanDetailPage.clickinvestBtn();

        boolean flag = loanDetailPage.investSuccessTipsisplayed();
        Assert.assertTrue(flag);
        driver.navigate().refresh();

        String afterText = loanDetailPage.getsurplusText();

        BigDecimal before = new BigDecimal("beforeText");
        BigDecimal after = new BigDecimal("afterText");
        BigDecimal result_amount = new BigDecimal("amount");
        BigDecimal result = before.subtract(after).multiply(new BigDecimal(10000));
        boolean flag2 = result.compareTo(result_amount) == 0;
        Assert.assertTrue(flag2);

    }
}
