package org.wujianbiao.javaBasic.thread.synchronizedTest;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/2/23 5:12 PM
 **/
public class SynchronizedDemo2 {

    Object object = new Object();

    public void method1() {
        synchronized (object) {

        }
        method2();
    }

    private static void method2() {

    }
}
