package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/6 下午1:04
 **/
public class Producer extends Thread {

    private Counter counter;

    public Producer(Counter counter) {
        this.counter = counter;
    }

    private void add() {
        for (int i = 0; i < Test.LOOP; ++i) {
            counter.add();
        }
    }

}
