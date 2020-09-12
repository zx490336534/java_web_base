package com.zhongxin.pages;

import com.zhongxin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage extends BasePage {

    //昵称
    private By nicknameBy = By.xpath("//a[contains(text(),'我的帐户[自动化测试帐号1]')]");
    //退出按钮
    private By logoutBtnBy = By.linkText("退出");
    //登陆按钮
    private By logintBtnBy = By.linkText("登录");


    public IndexPage(WebDriver driver) {
        super(driver);
    }


    // 昵称是否可见
    public boolean nicknameIsVisibility() {
        WebElement element = waitElementVisibility(nicknameBy);
        if (element != null) {
            return element.isDisplayed();
        }
        return false;
    }

    public void clickLogout() {
        WebElement element = waitElementClickable(logoutBtnBy);
        if (element != null) {
            element.click();
        }
    }

    public void clickLogin() {
        WebElement element = waitElementClickable(logintBtnBy);
        System.out.println("element" + element);
        if (element != null) {
            element.click();
        }
    }

}
