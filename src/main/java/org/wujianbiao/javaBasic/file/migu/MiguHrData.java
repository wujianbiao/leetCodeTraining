package org.wujianbiao.javaBasic.file.migu;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc 心率数据
 * @Author wujianbiao
 * @CreateTime 2024/4/16 4:58 PM
 **/
@Data
@NoArgsConstructor
public class MiguHrData {
    /**
     * 时间
     */
    private long time;

    /**
     * 纬度
     */
    private double lat;

    /**
     * 经度
     */
    private double lon;

    /**
     * 心率
     */
    private double hr;
}
