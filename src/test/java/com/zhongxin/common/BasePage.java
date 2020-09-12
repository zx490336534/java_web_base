package com.zhongxin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 封装显式等待:元素存在
     *
     * @param by 元素定位信息
     * @return 元素对象
     */
    public WebElement waitElementVisibility(By by) {
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

    /**
     * 封装显式等待:元素可点击
     *
     * @param by 元素定位信息
     * @return 元素对象
     */
    public WebElement waitElementClickable(By by) {
        WebElement element = null;
        try {
            //5秒元素可见显式等待
            WebDriverWait wait = new WebDriverWait(driver, 5);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            return element;
        } catch (Exception e) {
            System.out.println("元素定位异常" + e.getMessage());
        }
        return null;
    }

    public void input(By by, String content) {
        WebElement element = waitElementClickable(by);
        if (element != null) {
            element.clear();
            element.sendKeys(content);
        }
    }
}
