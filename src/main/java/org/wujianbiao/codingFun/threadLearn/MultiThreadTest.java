package org.wujianbiao.codingFun.threadLearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2021/2/18 10:10 下午
 **/
public class MultiThreadTest {
    public static void main(String[] args) throws Exception {

        // 创建固定大小的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            // 提交多个线程任务，并执行
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    printThreadInfo();
                }
            });
        }
    }

    /**
     * 输出当前线程的信息
     */
    private static void printThreadInfo() {
        System.out.println("当前运行的线程名为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
