package org.wujianbiao.javaBasic.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Desc 测试进程与线程
 * @Author wujianbiao
 * @CreateTime 2022/6/6 下午3:02
 **/
public class MultiThread {

    /**
     * JVM 进程，main 函数是其中一个线程
     * @param args
     */
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }

}
