package com.zhongxin.pages;

import com.zhongxin.common.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // phone元素定位信息
    private By phoneBy = By.name("phone");
    //password元素定位信息
    private By passwordBy = By.name("password");
    //登陆按钮元素定位信息
    private By loginBtnBy = By.xpath("//button[@class='btn btn-special']");
    //页面中央错误提示
    private By centerErrorBy = By.className("layui-layer-content");
    //页面手机红色错误提示
    private By phoneformErrorBy = By.xpath("//input[@name='phone']//following-sibling::div");
    //页面密码红色错误提示
    private By passwordformErrorBy = By.xpath("//input[@name='password']//following-sibling::div");
    //记住手机号码
    private By rememberMeBy = By.name("remember_me");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //对手机框进行输入
    public void inputPhone(String phone) {
        input(phoneBy, phone);
    }

    //对密码框进行输入
    public void inputPassword(String password) {
        input(passwordBy, password);
    }

    //点击登陆按钮
    public void clickLoginBtn() {
        click(loginBtnBy);
    }

    //获取页面中央错误提示文本
    public String getCenterErrorText() {
        return getElementText(centerErrorBy);

    }

    //获取页面手机红色错误提示
    public String getPhoneFormErrorText() {
        return getElementText(phoneformErrorBy);
    }

    //获取页面手机红色错误提示
    public String getPasswordFormErrorText() {
        return getElementText(passwordformErrorBy);
    }

    //勾选记住手机号码
    public void CheckRememberMe() {
        String checked = getElementAttribute(rememberMeBy, "checked");
        if (!"true".equals(checked)) {
            click(rememberMeBy);
        }
    }

    //获取手机号码
    public String getPhoneValue() {
        return getElementAttribute(phoneBy, "value");
    }
}
