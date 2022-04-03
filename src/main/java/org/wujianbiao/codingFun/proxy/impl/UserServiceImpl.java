package org.wujianbiao.codingFun.proxy.impl;

import org.wujianbiao.codingFun.proxy.UserService;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2020/8/20 下午6:09
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }

    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
