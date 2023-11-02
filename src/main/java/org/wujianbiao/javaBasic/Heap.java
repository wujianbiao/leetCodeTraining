package org.wujianbiao.javaBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/8/27 1:29 PM
 **/
public class Heap {

    static class OOMObject {

        private String s;

        private String g;
        private String d;
        private String q;
        private String w;
        private String r;
        private String e;

    }

    public static void main(String[] args) {

        List<OOMObject> ss = new ArrayList<>();

        try {

            while (true) {
                OOMObject oomObject = new OOMObject();
                ss.add(oomObject);

                // JVM 最大可用的
                double max = Runtime.getRuntime().maxMemory() / (1024);
                System.out.println("JVM 最大可用的:" + max + "KB");

                // JVM 剩余可用的
                double free = Runtime.getRuntime().freeMemory() / (1024);
                System.out.println("JVM 剩余可用的:" + free + "KB");

                System.out.println("===========");
            }
        } catch (Exception e) {

        }

    }
}
