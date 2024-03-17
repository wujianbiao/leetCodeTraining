package org.wujianbiao.javaBasic.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/3/5 3:43 PM
 **/
public class ThreadLocalTest {

    private static ThreadLocal<DateFormat> threadLocalTest = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static Date parse(String dateStr) {
        Date date = null;
        try {
            DateFormat dateFormat = threadLocalTest.get();
            System.out.println("输出 dateFormat" + dateFormat);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 40; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getId());
                System.out.println(parse("2024-03-05 15:55:44"));
            });
        }
    }
}
