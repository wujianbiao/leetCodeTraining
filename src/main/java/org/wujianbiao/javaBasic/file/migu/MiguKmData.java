package org.wujianbiao.javaBasic.file.migu;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/4/16 4:53 PM
 **/
@Data
@NoArgsConstructor
public class MiguKmData {
    /**
     * 经度
     */
    private double lon;

    /**
     * 每公里跑了多长时间，也就是配速（秒/公里）
     */
    private double d;

    /**
     * 每公里结束时的当前时间戳（秒）
     */
    private double t;

    /**
     * 纬度
     */
    private double lat;

    /**
     * 公里数，第几公里，下标从 1 开始。如果最后不满一公里，则为 -1
     */
    private int km;

    /**
     * 总的运动时长，相对开始时间的偏移量（秒）
     */
    private int sum_timer;
}
