package org.wujianbiao.javaBasic.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.dubbo.common.utils.CollectionUtils;

/**
 * @Desc 从公网下载zip文件并解析未对应的 javaBean
 * @Author wujianbiao
 * @CreateTime 2024/3/19 4:02 PM
 **/
public class ZipFileDownloader {
    public static void main(String[] args) {
        String fileUrl =
                "https://static1.keepcdn.com/infra-cms/2024/4/17/13/31/553246736447566b58312b43746477447845765752464d45775173416454427672356f527135714e65306b3d/0x0_edda99ac3e27475fc544137ff745aa7a341b8f34.zip";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(fileUrl)
                .build();

        List<MiguFileBeanDto> beanList = new ArrayList<>();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to download file: " + response);
            }

            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                try (InputStream inputStream = responseBody.byteStream();
                        ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {

                    ZipEntry entry = zipInputStream.getNextEntry();
                    while (entry != null) {
                        String name = entry.getName();
                        if (!entry.isDirectory() && !name.startsWith("_") && entry.getName().endsWith("test.txt")) {
                            String fileName = entry.getName();
                            System.out.println("开始解析：" + fileName);


                            ObjectMapper objectMapper = new ObjectMapper();
                            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                            objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
//                            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

                            // 读取ZipInputStream中的数据并转换为List<JavaBean>对象
                            beanList = objectMapper.readValue(zipInputStream,
                                    new com.fasterxml.jackson.core.type.TypeReference<List<MiguFileBeanDto>>() {});
                            System.out.println("解析完成");
                        }

                        entry = zipInputStream.getNextEntry();
                    }

                    System.out.println("ZIP 文件下载并解压成功！");
                }
            }

            for (MiguFileBeanDto beanDto : beanList) {
                if (CollectionUtils.isNotEmpty(beanDto.getKms())) {
                    System.out.println(beanDto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
