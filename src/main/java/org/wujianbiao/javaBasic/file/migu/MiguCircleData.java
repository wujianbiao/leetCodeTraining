package org.wujianbiao.javaBasic.file.migu;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/4/16 4:55 PM
 **/
@Data
@NoArgsConstructor
public class MiguCircleData {
    /**
     * 圈数
     */
    private int c;

    /**
     * 时间（秒）
     */
    private long m;

    /**
     * 距离（米）
     */
    private long d;
}
