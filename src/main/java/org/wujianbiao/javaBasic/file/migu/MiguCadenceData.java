package org.wujianbiao.javaBasic.file.migu;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc 步频步幅
 * @Author wujianbiao
 * @CreateTime 2024/4/16 4:56 PM
 **/
@Data
@NoArgsConstructor
public class MiguCadenceData {
    /**
     * ID
     */
    private int id;

    /**
     * 海拔，米
     */
    private double a;

    /**
     * 步频，步/分钟
     */
    private int b;

    /**
     * 步幅，米/步
     */
    private double c;

    /**
     * 记录的第几分钟，从 0 开始还是从 1 开始呢？
     */
    private int d;

    /**
     * 记录的里程，单位米
     */
    private double m;

    /**
     * 每分钟配速
     */
    private double s;
}
