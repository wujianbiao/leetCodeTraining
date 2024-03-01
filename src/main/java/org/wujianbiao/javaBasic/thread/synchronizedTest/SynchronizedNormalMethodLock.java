package org.wujianbiao.javaBasic.thread.synchronizedTest;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/2/23 4:58 PM
 **/
public class SynchronizedNormalMethodLock implements Runnable {

    static SynchronizedNormalMethodLock instance1 = new SynchronizedNormalMethodLock();
    static SynchronizedNormalMethodLock instance2 = new SynchronizedNormalMethodLock();

    @Override
    public void run() {
        method();
    }

    // synchronized 修饰普通方法，默认就是 this 锁，也就是锁单个实例。
    private synchronized void method() {
        System.out.println("我是线程 " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("我是线程 " + Thread.currentThread().getName() + "释放");
    }

    public static void main(String[] args) {
        // 1. 使用同一个对象的 instance1 作为锁对象，此时会串行执行
        // Thread thread1 = new Thread(instance1);
        // Thread thread2 = new Thread(instance1);
        //
        // thread1.start();
        // thread2.start();

        // 2. 使用不同对象 instance1 和 instance2，因为是独立的两个对象所以不会阻塞，会分别执行
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
    }

}
