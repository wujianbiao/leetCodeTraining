package org.wujianbiao.javaBasic.classload;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/3/1 12:22 PM
 **/
public class MyClassLoader extends ClassLoader{

    /**
     * 自定义类加载器，需要重写 findclass 方法，这是个钩子方法，在类加载的过程中会调用到。
     * 注意，这需要确保输入的 class 文件不能和对应的 java 文件在同一个路径下，不然就会被程序类加载器给加载掉。
     * @param name The <a href="#name">binary name</a> of the class
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
