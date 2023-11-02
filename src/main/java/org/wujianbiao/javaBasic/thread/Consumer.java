package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/6 下午1:01
 **/
public class Consumer extends Thread {
    Counter counter;

    public Consumer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int j = 0; j < Test.LOOP; j++) {
            counter.dec();
        }
    }
}
