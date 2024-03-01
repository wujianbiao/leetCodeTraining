package org.wujianbiao.javaBasic.thread.synchronizedTest;

/**
 * @Desc 测试 synchronized 对 this 的加锁操作
 * @Author wujianbiao
 * @CreateTime 2024/2/23 4:40 PM
 **/
public class SynchronizedObjectLock1 implements Runnable {
    static SynchronizedObjectLock1 instance = new SynchronizedObjectLock1();

    @Override
    public void run() {
        // 同步代码块形式——锁为this,两个线程使用的锁是一样的,线程1必须要等到线程0释放了该锁后，才能执行
        synchronized (this) {
            System.out.println("我是线程 " + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + "执行结束");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
    }
}
