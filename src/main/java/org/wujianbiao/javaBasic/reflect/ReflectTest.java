package org.wujianbiao.javaBasic.reflect;

import java.lang.reflect.Constructor;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/6/16 下午5:35
 **/
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        // User user = new User(12, "lll");
        // System.out.println(user.getClass());
        // System.out.println(User.class);
        // System.out.println(Class.forName("org.wujianbiao.reflect.javaBasic.User"));
        //
        // // 获取全限定名称
        // System.out.println(user.getClass().getName());
        // // 获取简易的类名，不包含包名
        // System.out.println(user.getClass().getSimpleName());
        // // 获取类加载器
        // System.out.println(user.getClass().getClassLoader());
        //
        // // 实例话对象
        // User user1 = User.class.newInstance();
        // System.out.println(user);
        // System.out.println(user1);


        // todo 如何获取字段名
        // Field[] fields = user.getFields();
        // System.out.println("fields are:" + fields.length);
        // for (Field field : fields) {
        // System.out.println(field.getName());
        // }

        testConstructor();

    }

    private static void testConstructor() throws Exception {
        Class<?> clazz = Class.forName("org.wujianbiao.javaBasic.reflect.User");


        Constructor cs1 = clazz.getConstructor(String.class);

        User user = (User) cs1.newInstance("ceshi");
        System.out.println(user);
        user.setUserName("改了");
        System.out.println(user);


        System.out.println("--------------------------------------------");

        // Constructor cs2 = clazz.getConstructor(Integer.class, String.class);
        // cs2.setAccessible(true);
        // User user1 = (User) cs2.newInstance(1, "私有");
        // System.out.println(user1);

    }
}
