package org.wujianbiao.codingFun.proxy;

import org.wujianbiao.codingFun.proxy.UserService;
import org.wujianbiao.codingFun.proxy.impl.UserServiceImpl;
import org.wujianbiao.codingFun.proxy.impl.UserServiceProxy;

/**
 * @Desc 测试静态代理
 * @Author wujianbiao
 * @CreateTime 2020/8/20 下午6:15
 **/
public class Client1 {
    public static void main(String[] args) {
        UserService userServiceTest = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceTest);

        proxy.select();
        proxy.update();
    }
}
