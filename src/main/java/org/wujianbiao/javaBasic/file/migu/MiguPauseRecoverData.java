package org.wujianbiao.javaBasic.file.migu;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/4/16 4:59 PM
 **/
@Data
@NoArgsConstructor
public class MiguPauseRecoverData {
    /**
     * 暂停或恢复时间（恢复时间，Long 10位时间戳）
     */
    private long oper_time;

    /**
     * 操作类型，0 暂停，1 恢复
     */
    private int type;

    /**
     * 标识，0 手动，1 自动
     */
    private int auto_flag;
}
