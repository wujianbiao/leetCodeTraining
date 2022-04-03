package org.wujianbiao.codingFun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2020/8/20 下午6:25
 **/
public class LogHandler implements InvocationHandler {

    /**
     * 被代理的对象，实际的方法执行者
     */
    Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        // 返回方法的执行结果
        return result;
    }

    // 调用invoke方法之前执行
    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    // 调用invoke方法之后执行
    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
