package com.zhongxin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // phone元素定位信息
    private By phoneBy = By.name("phone");
    //password元素定位信息
    private By passwordBy = By.name("password");
    //登陆按钮元素定位信息
    private By loginBtnBy = By.xpath("//button[@class='btn btn-special']");
    //页面中央错误提示
    private By centerErrorBy = By.className("layui-layer-content");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //对手机框进行输入
    public void inputPhone(String phone) {
        driver.findElement(phoneBy).sendKeys(phone);
    }

    //对密码框进行输入
    public void inputPassword(String password) {
        driver.findElement(passwordBy).sendKeys(password);
    }

    //点击登陆按钮
    public void clickLoginBtn() {
        driver.findElement(loginBtnBy).click();
    }

    //获取页面中央错误提示文本
    public String getCenterErrorText() {
        return driver.findElement(centerErrorBy).getText();
    }
}
