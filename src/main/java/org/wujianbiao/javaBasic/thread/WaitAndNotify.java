package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/3/5 5:35 PM
 **/
public class WaitAndNotify {

    public static Object object = new Object();

    static class Thread0 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "初次获得对象锁，执行中，调用共享对象的wait()方法...");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "再次获得对象锁，执行结束");
            }
        }
    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "初次获得对象锁，执行中，即将调用 notify()方法...");
                object.notify();
                System.out.println(Thread.currentThread().getName() + "获得对象锁，执行中，调用了共享对象的notify()方法");
            }
        }
    }

    public static void main(String[] args) {
        Thread0 thread0 = new Thread0();
        Thread1 thread1 = new Thread1();
        thread0.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread1.start();
    }
}
