package org.wujianbiao.javaBasic.file.migu;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 运动轨迹
 */
@Data
@NoArgsConstructor
public class MiguPathData {
    /**
     * 爬坡值，单位米
     */
    private int a;

    /**
     * 经度
     */
    private double lon;

    /**
     * 纬度
     */
    private double lat;

    /**
     * 添加时间，几位时间戳？
     */
    private int time;

    /**
     * 是否起始点，取值0或1，1-起点
     */
    private int s;

    /**
     * 累计
     */
    private int accu;
}
