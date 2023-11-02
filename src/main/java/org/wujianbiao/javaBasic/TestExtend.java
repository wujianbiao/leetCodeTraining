package org.wujianbiao.javaBasic;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2022/5/28 下午3:56
 **/
public class TestExtend extends BasicThings {
    private TestExtend() {
        super();
    }

    /**
     * 测试继承多态
     * 武昌鱼和鲈鱼都可以用鱼来形容，但是鱼不一定指的是武昌鱼，需要特别强调。
     */
    private void testExtend() {
        TestExtend eg1 = new TestExtend();

        // new 父类的时候，不能使用子类来接收，需要强转。
        TestExtend eg2 = (TestExtend) new BasicThings();

        // new 子类的时候，可以直接使用子类接收。
        BasicThings eg3 = new TestExtend();
    }
}
