package org.wujianbiao.ai.model;

import lombok.Data;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/10/19 4:51 PM
 **/
@Data
public class CompletionRequest {
    private String model = "text-davinci-003";
    private String prompt;
    private Integer maxTokens = 256;
    private float temperature = 0.5f;
    private Integer topP = 1;
    private Integer n = 1;
    private Boolean stream = false;
    private Boolean logprobs;
    private String stop;
}
