package org.wujianbiao.javaBasic.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/11/23 2:17 PM
 **/
public class TestSpi {

    public static void main(String[] args) {
        Log logService = ExtensionLoader.getExtensionLoader(Log.class).getAdaptiveExtension();
        URL url = URL.valueOf("dubbo://localhost:20882?log.service=log4j");
        System.out.println(logService.hello(url));
    }
}
