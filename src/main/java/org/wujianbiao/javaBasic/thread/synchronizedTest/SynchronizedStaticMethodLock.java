package org.wujianbiao.javaBasic.thread.synchronizedTest;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/2/23 4:58 PM
 **/
public class SynchronizedStaticMethodLock implements Runnable {

    static SynchronizedStaticMethodLock instance1 = new SynchronizedStaticMethodLock();
    static SynchronizedStaticMethodLock instance2 = new SynchronizedStaticMethodLock();

    @Override
    public void run() {
        method();
    }

    // synchronized 修饰 static 方法，类方法，锁的是类的所有实例
    private static synchronized void method() {
        System.out.println("我是线程 " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("我是线程 " + Thread.currentThread().getName() + "释放");
    }

    public static void main(String[] args) {

        // 使用不同对象 instance1 和 instance2，但因为是在 static 方法上的锁，是类方法，所以会阻塞，会串行执行
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
    }

}
