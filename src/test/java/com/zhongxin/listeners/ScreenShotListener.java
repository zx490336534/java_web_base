package com.zhongxin.listeners;

import com.zhongxin.common.BaseCase;
import com.zhongxin.utils.ScreenShotUtils;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class ScreenShotListener implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        // iHookCallBack 用例执行@Test方法的
        // iTestResult @Test方法的结果(@Test对象/方法名/是否抛出异常)
        iHookCallBack.runTestMethod(iTestResult);
        Throwable throwable = iTestResult.getThrowable();
        if (throwable != null) {
            //throwable不等于异常说明@Test出现异常了，执行截图
            Object object = iTestResult.getInstance();
            BaseCase logincase = (BaseCase) object;
            //获取当前@Test方法名
            String methodName = iTestResult.getName();
            //获取当前@Test类名
            String className = iTestResult.getInstanceName();
            String destFilename = className + "_" + methodName + "_" + System.currentTimeMillis() + ".png";
            ScreenShotUtils.screenShot(logincase.driver, destFilename);
        }

    }
}
