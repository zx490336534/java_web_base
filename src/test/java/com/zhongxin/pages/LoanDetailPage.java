package com.zhongxin.pages;

import com.zhongxin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanDetailPage extends BasePage {
    //投资金额
    private By investAmountBy = By.xpath("//input[@data-url='/Invest/invest']");
    //投资按钮
    private By investBtnBy = By.xpath("//button[text()='投标']");
    //投标成功提示框
    private By investSuccessTipsBy = By.xpath("//div[contains(text(),'投标成功']");
    //剩余
    private By surplusBy = By.xpath("//span[text()='剩余：']//following-sibling::span");

    public LoanDetailPage(WebDriver driver) {
        super(driver);
    }

    public void inputInvestAmount(String amount) {
        input(investAmountBy, amount);
    }

    public void clickinvestBtn() {
        click(investBtnBy);
    }

    public boolean investSuccessTipsisplayed() {
        return elementIsDisplayed(investSuccessTipsBy);
    }

    public String getsurplusText() {
        return getElementText(surplusBy);
    }

}
