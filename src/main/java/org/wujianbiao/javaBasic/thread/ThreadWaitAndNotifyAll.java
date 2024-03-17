package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/3/5 5:59 PM
 **/
public class ThreadWaitAndNotifyAll implements Runnable {

    public static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("线程" + Thread.currentThread().getName() + "获得锁，进入等待状态");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行最后部分结束");
        }
    }

    public static void main(String[] args) {
        ThreadWaitAndNotifyAll runnable = new ThreadWaitAndNotifyAll();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程" + Thread.currentThread().getName() + "获得锁，开始通知唤醒所有线程");
                    object.notifyAll();
                    System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();
    }
}
