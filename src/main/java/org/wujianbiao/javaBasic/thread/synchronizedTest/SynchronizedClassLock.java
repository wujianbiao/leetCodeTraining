package org.wujianbiao.javaBasic.thread.synchronizedTest;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/2/23 4:58 PM
 **/
public class SynchronizedClassLock implements Runnable {

    static SynchronizedClassLock instance1 = new SynchronizedClassLock();
    static SynchronizedClassLock instance2 = new SynchronizedClassLock();

    @Override
    public void run() {
        method();
    }

    private void method() {
        synchronized (SynchronizedClassLock.class) {
            System.out.println("我是线程 " + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("我是线程 " + Thread.currentThread().getName() + "释放");
        }
    }

    public static void main(String[] args) {

        // 使用不同对象 instance1 和 instance2，但因为是在 .class 上的锁，锁的是类的所有实例对象
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
    }

}
