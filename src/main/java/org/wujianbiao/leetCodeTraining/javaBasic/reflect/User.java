package org.wujianbiao.leetCodeTraining.javaBasic.reflect;

import java.io.Serializable;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/16 下午5:28
 **/
public class User implements Serializable {

    private int age;

    private String userName = "nike";

    public User() {}

    private User(int age, String userName) {
        this.age = age;
        this.userName = userName;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return this.userName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public String toString() {
        return "User [name=" + userName + ", age=" + age + "]";
    }
}
