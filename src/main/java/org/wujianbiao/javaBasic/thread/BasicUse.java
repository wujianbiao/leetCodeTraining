package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/2/23 10:29 AM
 **/
public class BasicUse {

    public static void main(String[] args) {
        System.out.println("这是主线程");
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        createAndRun();
    }

    // 1. 线程的创建和启动方式
    public static void createAndRun() {
        Thread thread = new Thread(() -> {
            System.out.println("线程运行中");
        });

        thread.run();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(thread.getId());
        System.out.println(thread.getName());
    }

    // 1. 线程的创建和启动方式
    public static void createRunnableAndRun() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("this is runnable");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
