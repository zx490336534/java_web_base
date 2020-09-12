package com.zhongxin.pages;

import com.zhongxin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return elementIsDisplayed(nicknameBy);
    }

    public void clickLogout() {
        click(logoutBtnBy);
    }

    public void clickLogin() {
        click(logintBtnBy);
    }

}
