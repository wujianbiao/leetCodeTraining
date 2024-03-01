package org.wujianbiao.javaBasic.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc 使用 codition 演示生产者消费者模型
 * @Author wujianbiao
 * @CreateTime 2024/2/23 2:55 PM
 **/
@Slf4j
public class ProducerConsumerExample {

    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 10;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce(int value) throws InterruptedException {
        // 线程先持有锁才能进到后续流程
        lock.lock();
        System.out.println("生产者线程拿到锁");
        try {
            // 如果当前队列满了，则当前生产者线程被放入等待队列 1 中，不会执行下面的 add 操作。
            while (queue.size() == capacity) {
                System.out.println("producer 线程等待");
                notFull.await();
            }

            // 如果执行到这里，说明队列不满
            queue.add(value);
            System.out.println("Produced: " + value);
            // 加入元素之后，队列不为空，此时通过 notEmpty 来通知消费线程。
            // 本质是唤醒在 notEmpty 这个条件队列 2 上等待的消费者线程。
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        // 消费线程也需要先获取到锁才能进到后续流程
        lock.lock();
        System.out.println("消费者线程拿到锁");
        try {
            // 如果队列为空，则当前消费线程被放入到等待队列 2 中，不会执行下方的 poll 操作。
            while (queue.isEmpty()) {
                notEmpty.await();
                System.out.println("consume 线程等待");
            }

            // 如果执行到这里，说明队列不为空。
            int value = queue.poll();
            System.out.println("Consumed: " + value);

            // 消费完i个节点之后等待 1 秒钟，故意拖慢消费速度，从而让生产线程尽快把队列塞满。
            Thread.sleep(1000);

            // 在消费完之后，当前队列一定不是满的，则铜驼 notFull 通知生产者线程。
            // 本质是唤醒在 notFull 这个条件队列 1 上等待的生产者线程。
            notFull.signalAll();
            return value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    example.produce(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    example.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}


