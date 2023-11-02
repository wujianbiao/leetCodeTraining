package org.wujianbiao.javaBasic;

import java.util.ArrayList;

/**
 * @Desc 随时放一些零碎的知识点或者测试，大块的内容需要整理为单独的类
 * @Author wujianbiao
 * @CreateTime 2022/5/28 上午9:47
 **/
public class BasicThings {

    public BasicThings() {
        System.out.println("无参构造");
    }

    public BasicThings(int value) {
        System.out.println("有参构造：" + value);
    }


    public static void main(String[] args) {
        // test1(1);
        // testInteger(10);
        // testInteger(180);
        testArrayLength();
    }

    private static void test1(int value) {
        int a = value++;
        int b = ++value;

        System.out.println(a);
        System.out.println(b);
    }

    private static void testArrayLength() {
        String[] arr = new String[10];
        arr[1] = "sss";
        System.out.println(arr.length);
    }

    private static void testInteger(int value) {
        Integer int1 = value;
        Integer int2 = new Integer(value);
        Integer int3 = Integer.valueOf(value);
        System.out.println(int1 == int2);
        System.out.println(int1 == int3);
        System.out.println(int2 == int3);
        System.out.println(int1.equals(int2));
        System.out.println(int2.equals(int3));
        System.out.println("---分割线---");
    }

}
