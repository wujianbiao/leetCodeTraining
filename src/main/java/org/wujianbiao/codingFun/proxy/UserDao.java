package org.wujianbiao.codingFun.proxy;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2020/8/20 下午7:34
 **/
public class UserDao {
    public void select() {
        System.out.println("UserDao 查询 selectById");
    }

    public void update() {
        System.out.println("UserDao 更新 update");
    }
}
