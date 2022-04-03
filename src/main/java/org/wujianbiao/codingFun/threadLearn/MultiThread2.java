package org.wujianbiao.codingFun.threadLearn;

import java.util.Date;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2021/2/18 10:06 下午
 **/
public class MultiThread2 implements Runnable {

    private int num;

    public MultiThread2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println("a");
        }
    }

}
