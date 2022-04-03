package org.wujianbiao.codingFun.threadLearn;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2021/2/18 10:06 下午
 **/
public class MultiThread3 implements Runnable {

    private int num;

    public MultiThread3(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println(i);
        }
    }

}
