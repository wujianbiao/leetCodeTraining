package org.wujianbiao.codingFun.proxy.impl;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2020/8/20 下午7:35
 **/
public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects); // 注意这里是调用 invokeSuper 而不是
                                                             // invoke，否则死循环，methodProxy.invokesuper执行的是原始类的方法，method.invoke执行的是子类的方法
        after();
        return result;
    }

    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
