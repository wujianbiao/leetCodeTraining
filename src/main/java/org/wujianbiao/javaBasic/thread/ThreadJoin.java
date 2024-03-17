package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/3/5 6:34 PM
 **/
public class ThreadJoin {

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程" + Thread.currentThread().getName() + "获得锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程" + Thread.currentThread().getName() + "获得锁");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
                }
            }
        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();

        thread1.join();
        System.out.println("主线程执行结束");
    }
}
