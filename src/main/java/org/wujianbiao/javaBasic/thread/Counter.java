package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/6 下午12:42
 **/
public class Counter {

    int num = 0;

    public void add() {
        num += 1;
    }

    public void dec() {
        num -= 1;
    }

    public int getNum() {
        return num;
    }
    //
    // public static void main(String[] args) throws InterruptedException {
    //
    // int s = 0;
    // s = s++;
    // System.out.println(s);
    //
    // Counter x = new Counter();
    //
    // Thread thread1 = new Thread(() -> {
    // for (int i = 0; i < 1000; i++) {
    // x.inc();
    //
    // System.out.println(x.getNum() + "--" + Thread.currentThread().getName());
    // }
    // });
    //
    // System.out.println(x.getNum());
    //
    // Thread thread2 = new Thread(() -> {
    // for (int i = 0; i < 1000; i++) {
    // x.inc();
    // System.out.println(x.getNum() + "--" + Thread.currentThread().getName());
    // }
    // });
    //
    //
    // thread1.start();
    // thread2.start();
    // thread1.join();
    // thread2.join();
    // System.out.println(x.getNum());
    //
    // }
}
