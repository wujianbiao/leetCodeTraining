package org.wujianbiao.codingFun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.wujianbiao.codingFun.proxy.impl.UserServiceImpl;


/**
 * @Desc JDK 动态代理
 * @Author wujianbiao
 * @CreateTime 2020/8/20 下午6:35
 **/
public class Client2 {
    public static void main(String[] args) {

        // 设置变量可以保存动态代理类，默认名称以 $Proxy0 格式命名
        // System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        UserServiceImpl userServiceImpl = new UserServiceImpl();
        ClassLoader classLoader = userServiceImpl.getClass().getClassLoader();

        Class[] interfaces = userServiceImpl.getClass().getInterfaces();

        InvocationHandler logHandler = new LogHandler(userServiceImpl);

        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);

        proxy.select();
        proxy.update();

        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        ProxyUtils.generateClassFile(userServiceImpl.getClass(), "UserServiceProxy");
    }
}
