package org.wujianbiao.ai;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wujianbiao.ai.model.CompletionRequest;
import org.wujianbiao.leetCodeTraining.LeetCodeTrainingApplication;

import com.alibaba.fastjson.JSON;

import okhttp3.*;

/**
 * @Desc
 * @Author wujianbiao
 * @CreateTime 2023/10/19 4:50 PM
 **/
@SpringBootTest(classes = LeetCodeTrainingApplication.class)
public class ChatGptTest {

    @Test
    void contextLoads() {
        completion("你好吗？");
    }

    public static void completion(String prompt) {
        CompletionRequest completionRequest = new CompletionRequest();
        completionRequest.setPrompt(prompt);
        completionRequest.setModel("text-davinci-003");

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        String apiKey = "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";


        String reqJson = JSON.toJSONString(completionRequest);
        System.out.println("reqJson: " + reqJson);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/completions")
                // 将 API_KEY 替换成你自己的 API_KEY
                .header("Authorization", "Bearer " + apiKey)
                .post(RequestBody.create(reqJson, MediaType.parse("application/json")))
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("something wrong");
            } ;
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
