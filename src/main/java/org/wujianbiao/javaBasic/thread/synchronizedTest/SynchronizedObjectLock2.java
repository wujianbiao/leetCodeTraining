package org.wujianbiao.javaBasic.thread.synchronizedTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Desc 演示 synchronized 对不同对象的加锁
 * @Author wujianbiao
 * @CreateTime 2024/2/23 4:48 PM
 **/
public class SynchronizedObjectLock2 implements Callable {

    static SynchronizedObjectLock2 instance = new SynchronizedObjectLock2();

    Object object1 = new Object();
    Object object2 = new Object();

    @Override
    public Object call() {
        // 这里持有的是 object1
        synchronized (object1) {
            System.out.println("正在持有 object1 当前线程是 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("释放 object1 当前线程是 " + Thread.currentThread().getName());
        }

        // 这里持有的是 object2
        synchronized (object2) {
            System.out.println("正在持有 object2 当前线程是 " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("释放 object2 当前线程是 " + Thread.currentThread().getName());
        }
        return null;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new FutureTask<>(instance));
        Thread thread2 = new Thread(new FutureTask<>(instance));

        thread1.start();
        thread2.start();
    }

}
