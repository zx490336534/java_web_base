package com.zhongxin.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private Logger log = Logger.getLogger(BasePage.class);

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
        log.info(by);
        WebElement element = null;
        try {
            //5秒元素可见显式等待
            WebDriverWait wait = new WebDriverWait(driver, 5);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element;
        } catch (Exception e) {
            log.error("元素定位异常" + e.getMessage());
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
        log.info(by);
        WebElement element = null;
        try {
            //5秒元素可见显式等待
            WebDriverWait wait = new WebDriverWait(driver, 5);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            return element;
        } catch (Exception e) {
            log.error("元素定位异常" + e.getMessage());
        }
        return null;
    }

    /**
     * 输入文本框
     *
     * @param by      元素定位
     * @param content 文本内容
     */
    public void input(By by, String content) {
        WebElement element = waitElementClickable(by);
        if (element != null) {
            element.clear();
            element.sendKeys(content);
        }
    }

    /**
     * 点击
     *
     * @param by 元素定位
     */
    public void click(By by) {
        WebElement element = waitElementClickable(by);
        if (element != null) {
            element.click();
        }
    }

    /**
     * 获取元素的文本
     *
     * @param by 元素定位
     */
    public String getElementText(By by) {
        WebElement element = waitElementVisibility(by);
        if (element != null) {
            return element.getText();
        }
        return "";
    }

    /**
     * 获取元素的属性值
     *
     * @param by            元素定位
     * @param attributeName 元素属性
     */
    public String getElementAttribute(By by, String attributeName) {
        WebElement element = waitElementVisibility(by);
        String value = "";
        if (element != null) {
            value = element.getAttribute(attributeName);
        }
        return value;
    }

    /**
     * 元素是否可见
     *
     * @param by 元素定位
     */
    public boolean elementIsDisplayed(By by) {
        WebElement element = waitElementVisibility(by);
        if (element != null) {
            return element.isDisplayed();
        }
        return false;
    }

    /**
     * 输入键盘key
     *
     * @param by  元素定位
     * @param key 键盘内容
     */
    public void inputKey(By by, Keys key) {
        WebElement element = waitElementVisibility(by);
        if (element != null) {
            element.sendKeys(key);
        }

    }
}
