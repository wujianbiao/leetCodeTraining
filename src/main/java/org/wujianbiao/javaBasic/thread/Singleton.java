package org.wujianbiao.javaBasic.thread;

/**
 * @Desc 经典单例模式
 * @Author wujianbiao
 * @CreateTime 2024/5/12 3:33 PM
 **/
public class Singleton {

    private static volatile Singleton singleton;

    public Singleton getObj() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    // 这一步操作实际上分为三步
                    // 1.申请一块内存
                    // 2.初始化 singleton 对象
                    // 3.将内存地址指向 singleton
                    // 在不使用 volatile 修饰时，这三步的顺序可能是 1-2-3，也可能是 1-3-2。
                    // 当 线程A 执行完 3 这步时，另一个 线程B 在判断 singleton==null 时直接返回 false，从而直接返回了一个
                    // 没有初始化的对象。
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
