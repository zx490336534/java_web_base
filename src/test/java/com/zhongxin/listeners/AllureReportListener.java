package com.zhongxin.listeners;

import com.zhongxin.common.BaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class AllureReportListener implements IHookable {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
        Throwable throwable = iTestResult.getThrowable();
        if (throwable != null) {
            //throwable不等于异常说明@Test出现异常了，执行截图
            Object object = iTestResult.getInstance();
            BaseCase baseCase = (BaseCase) object;
            TakesScreenshot screenshot = (TakesScreenshot) baseCase.driver;
            byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenshotAs);
        }
    }
}
