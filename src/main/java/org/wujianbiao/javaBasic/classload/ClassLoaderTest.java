package org.wujianbiao.javaBasic.classload;

/**
 * @Desc 测试 classLoader
 * @Author wujianbiao
 * @CreateTime 2024/3/1 12:10 PM
 **/
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());

        long initalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println(initalMemory);
        System.out.println(maxMemory);

    }
}
