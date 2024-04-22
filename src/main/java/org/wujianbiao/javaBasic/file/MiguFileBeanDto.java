package org.wujianbiao.javaBasic.file;

import java.io.Serializable;
import java.util.List;

import org.wujianbiao.javaBasic.file.migu.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2024/3/26 2:15 PM
 **/
@Data
@NoArgsConstructor
public class MiguFileBeanDto implements Serializable {

    private static final long serialVersionUID = 1206020917759427539L;
    private String userId;

    /**
     * 运动类型
     * 1 室外跑
     * 2 骑行
     * 3 室内跑
     * 4 计步
     * 5 跳绳
     * 6 健步
     * 7 训练
     */
    private int sportType;

    /**
     * 1 正常
     * 2 轻微可疑
     * 3 可疑
     * 4 非常可疑
     * 5 严重可疑
     */
    private int status;

    /**
     * 运动ID
     */
    private String motion_id;

    /**
     * 持续时间（秒，10 位）
     */
    private int time_use;

    /**
     * 开始时间（秒,10 位）
     */
    private int start_time;

    /**
     * 结束时间（秒，10 位）
     */
    private int finish_time;

    /**
     * 全程距离（米）
     */
    private int run_mileage;

    /**
     * 最快速度（米/秒）
     */
    private double fastest_speed;

    /**
     * 最慢速度（米/秒）
     */
    private double slowest_speed;

    /**
     * 平均速度（米/秒）
     */
    private double average_speed;

    /**
     * 卡路里
     */
    private double use_calorie;

    /**
     * 累计爬升（米）
     */
    private int altitude;

    /**
     * 半马耗时（秒）
     * TODO 半马和全马的逻辑还未处理
     */
    private int half_marathon_time;

    /**
     * 全马耗时（秒）
     */
    private int full_marathon_time;

    /**
     * 每公里的运动数据
     */
    private List<MiguKmData> kms;

    /**
     * 计圈数据
     */
    private List<MiguCircleData> circle;

    /**
     * 步频步幅
     */
    private List<MiguCadenceData> cadence;

    /**
     * 运动轨迹
     */
    private List<MiguPathData> path;

    /**
     * 心率数据
     */
    private List<MiguHrData> hrs;

    /**
     * 暂停与恢复时间
     */
    private List<MiguPauseRecoverData> pause_recove;

    /**
     * 最大心率
     */
    private double max_hr;

    /**
     * 平均心率
     */
    private double avg_hr;

    /**
     * 步数
     */
    private int steps_number;

    /**
     * 平均步频
     * sport_type=1 时返回。
     * 行走和健走的时候不返回步频吗？
     */
    private int avg_cadence;

    /**
     * 步幅
     * 步幅。普通数据返回avg_cadence，avg_stride
     */
    private float avg_stride;
}
