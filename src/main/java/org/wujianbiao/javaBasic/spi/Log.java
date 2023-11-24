package org.wujianbiao.javaBasic.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * 验证 JDK SPI
 * 
 * @author wujianbiao
 * @date 2023/11/22 3:00 PM
 */
@SPI("log4j")
public interface Log {
    @Adaptive
    String hello(URL url);
}
