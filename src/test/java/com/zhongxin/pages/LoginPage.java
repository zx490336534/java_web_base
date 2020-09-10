package com.zhongxin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private WebDriver driver;

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

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //对手机框进行输入
    public void inputPhone(String phone) {
        WebElement element = waitElementBisibility(phoneBy);
        if (element != null) {
            element.clear();
            element.sendKeys(phone);
        }
    }

    //对密码框进行输入
    public void inputPassword(String password) {
        WebElement element = waitElementBisibility(passwordBy);
        if (element != null) {
            element.clear();
            element.sendKeys(password);
        }
    }

    //点击登陆按钮
    public void clickLoginBtn() {
        WebElement element = waitElementBisibility(loginBtnBy);
        if (element != null) {
            element.click();
        }

    }

    //获取页面中央错误提示文本
    public String getCenterErrorText() {
        WebElement element = waitElementBisibility(centerErrorBy);
        if (element != null) {
            return element.getText();
        }
        return "";
    }

    //获取页面手机红色错误提示
    public String getPhoneFormErrorText() {
        WebElement element = waitElementBisibility(phoneformErrorBy);
        if (element != null) {
            return element.getText();
        }
        return "";
    }

    //获取页面手机红色错误提示
    public String getPasswordFormErrorText() {
        WebElement element = waitElementBisibility(passwordformErrorBy);
        if (element != null) {
            return element.getText();
        }
        return "";
    }


}
