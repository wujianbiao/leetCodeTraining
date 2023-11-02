package org.wujianbiao.javaBasic.extend;

import lombok.Data;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/8/22 8:44 PM
 **/
@Data
public class Son extends Father {

    private String sonName;

    private String sonAge;

    public void eat() {}

}
