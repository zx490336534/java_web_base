package com.zhongxin.pages;

import com.zhongxin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackstageIndexPage extends BasePage {
    private WebDriver driver;
    //借款管理按钮
    private By loanManageBy = By.partialLinkText("借款管理");
    //mainFrame
    private By mainFrameBy = By.id("mainFrame");
    //加标按钮
    private By addLoanBy = By.id("add");
    //借款人
    private By borrowerBy = By.xpath("//input[@placeholder='请输入手机号码进行查找']");
    //贷款标题
    private By titleBy = By.xpath("//td[text()='贷款标题:']//following-sibling::td/input");
    //年利率利息
    private By loanRateBy = By.xpath("//td[text()='年利率利息:']//following-sibling::td/input");
    //借款期限
    private By loanTermBy = By.xpath("//td[text()='借款期限:']//following-sibling::td/input");
    //借款额度
    private By amountBy = By.xpath("//td[text()='借款额度:']//following-sibling::td/input");
    //竞标期限
    private By biddingDaysBy = By.xpath("//td[text()='竞标期限:']//following-sibling::td/input");
    //风控评测
    private By evaluationBy = By.xpath("//span[text()='风控评估']");
    //评估价值
    private By evaluAmountBy = By.xpath("//td[text()='评估价值:']//following-sibling::td/input");
    //项目录入
    private By projectInputBy = By.xpath("//span[text()='项目录入']");
    //籍贯
    private By hometownBy = By.xpath("//td[text()='籍贯:']//following-sibling::td/input");
    //职业
    private By jobBy = By.xpath("//td[text()='职业:']//following-sibling::td/input");
    //年龄
    private By ageBy = By.xpath("//td[text()='年龄:']//following-sibling::td/input");
    //提交
    private By addDoBy = By.id("add_do");
    //审核按钮
    private By checkBy = By.id("check");
    //审核通过按钮
    private By checkPassBy = By.xpath("//*[@id=\"check_loan\"]/div[2]/a[1]/span/span");

    public BackstageIndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoanManage() {
        click(loanManageBy);
    }

    public void clickAddLoan() {
        WebElement element = waitElementVisibility(mainFrameBy);
        driver.switchTo().frame(element);
        click(addLoanBy);
    }

    public void inputBorrower(String phone) {
        try {
            input(borrowerBy, phone);
            Thread.sleep(2000);
            inputKey(borrowerBy, Keys.ARROW_DOWN);
            Thread.sleep(2000);
            inputKey(borrowerBy, Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("元素定位异常" + e.getMessage());
        }
    }

    //贷款标题
    public void inputTitle(String title) {
        input(titleBy, title);
    }

    //年利率利息
    public void inputloanRate(String loanRate) {
        input(loanRateBy, loanRate);
    }

    //借款期限
    public void inputloanTerm(String loanTerm) {
        input(loanTermBy, loanTerm);
    }

    //借款额度
    public void inputamount(String amount) {
        input(amountBy, amount);
    }

    //竞标期限
    public void inputbiddingDays(String biddingDays) {
        input(biddingDaysBy, biddingDays);
    }

    //风控评测
    public void clickevaluation() {
        click(evaluationBy);
    }

    //评估价值
    public void inputevaluAmount(String evaluAmount) {
        input(evaluAmountBy, evaluAmount);
    }

    //项目录入
    public void clickprojectInput() {
        click(projectInputBy);
    }

    //籍贯
    public void inputhometown(String hometown) {
        input(hometownBy, hometown);
    }

    //职业
    public void inputjob(String job) {
        input(jobBy, job);
    }

    //年龄
    public void inputage(String age) {
        input(ageBy, age);
    }

    //提交
    public void clickAdddo() {
        click(addDoBy);
    }

    //点击标题相对的一行数据
    public void clickTitleRow(String title) {
        try {
            Thread.sleep(1000);
            By by = By.xpath("//div[text=']" + title + "']/parent::td/parent::tr");
            click(by);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //点击审核按钮
    public void clickCheck() {
        click(checkBy);
    }

    //点击审核通过按钮
    public void clickCheckPass() {
        click(checkPassBy);
    }

}
