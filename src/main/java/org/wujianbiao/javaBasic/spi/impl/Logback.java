package org.wujianbiao.javaBasic.spi.impl;

import org.apache.dubbo.common.URL;
import org.springframework.stereotype.Service;
import org.wujianbiao.javaBasic.spi.Log;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/11/22 3:02 PM
 **/
@Service
public class Logback implements Log {
    @Override
    public String hello(URL url) {
        System.out.println("this is Logback");
        return "";
    }
}
