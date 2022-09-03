package com.zhongxin.pages;

import com.zhongxin.common.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackstageLoginPage extends BasePage {
    private By usernameBy = By.name("admin_name");
    private By passwordBy = By.name("admin_pwd");
    private By codeBy = By.name("code");
    private By loginBtnBy = By.xpath("//button[@class='admin_login_btn denglu']");

    public BackstageLoginPage(WebDriver driver) {
        super(driver);
    }

    //输入账号
    public void inputUsername(String username) {
        input(usernameBy, username);
    }

    //输入密码
    public void inputPassword(String password) {
        input(passwordBy, password);
    }

    //输入验证码
    public void inputCode(String code) {
        input(codeBy, code);
    }

    //点击登录按钮
    public void clickLoginBtn() {
        click(loginBtnBy);
    }

}
