package com.zhongxin.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer retryAnalyzer = iTestAnnotation.getRetryAnalyzer();
        if (retryAnalyzer == null) {
            //@Test 没有设置retryAnalyzer属性，帮你设置一个属性
            iTestAnnotation.setRetryAnalyzer(MyRetry.class);
        }
    }
}
