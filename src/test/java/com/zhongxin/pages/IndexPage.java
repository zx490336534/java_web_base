package com.zhongxin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage extends BasePage {
    private WebDriver driver;

    //昵称
    private By nicknameBy = By.xpath("//a[contains(text(),'我的帐户[自动化测试帐号1]')]");

    public IndexPage(WebDriver driver) {
        super(driver);
    }


    // 昵称是否可见
    public boolean nicknameIsVisibility() {
        WebElement element = waitElementBisibility(nicknameBy);
        if (element != null) {
            return element.isDisplayed();
        }
        return false;
    }

}
