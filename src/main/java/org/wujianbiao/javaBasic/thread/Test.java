package org.wujianbiao.javaBasic.thread;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/6 下午1:03
 **/
public class Test {

    static final int LOOP = 1000;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Producer producer = new Producer(counter);
        Consumer consumer = new Consumer(counter);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(counter.getNum());
    }
}
