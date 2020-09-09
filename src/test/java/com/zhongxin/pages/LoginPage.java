package com.zhongxin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    //页面红色错误提示
    private By formErrorBy = By.className("form-error-info");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
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

    //获取页面红色错误提示
    public String getFormErrorText() {
        WebElement element = waitElementBisibility(formErrorBy);
        if (element != null) {
            return element.getText();
        }
        return "";
    }

    /**
     * 封装显式等待
     *
     * @param by 元素定位信息
     * @return 元素对象
     */
    public WebElement waitElementBisibility(By by) {
        WebElement element = null;
        try {
            //5秒元素可见显式等待
            WebDriverWait wait = new WebDriverWait(driver, 5);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element;
        } catch (Exception e) {
            System.out.println("元素定位异常" + e.getMessage());
        }
        return null;
    }
}
