package tech.zenblob.wecomconnectservice.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.apache.http.HttpStatus.SC_OK;

public final class HttpClient {
    private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom().setSocketTimeout(15000)
            .setConnectTimeout(10000).build();
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

    /**
     * 采用Get方式发送请求，获取响应数据
     */
    public static JSONObject httpGet(String url) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(REQUEST_CONFIG);
        try {
            CloseableHttpResponse chr = client.execute(httpGet);
            int statusCode = chr.getStatusLine().getStatusCode();
            if (SC_OK != statusCode) {
                throw new RuntimeException(String.format("%s查询出现异常", url));
            }
            String entity = EntityUtils.toString(chr.getEntity(), StandardCharsets.UTF_8);
            JSONObject object = JSONObject.parseObject(entity);
            return object;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(String.format("%s", url) + "查询出现异常");
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 采用Post方式发送请求，获取响应数据
     *
     * @param url   url地址
     * @param param 参数值键值对的字符串
     */
    public static String httpPost(String url, String param) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpPost post = new HttpPost(url);
            EntityBuilder builder = EntityBuilder.create();
            builder.setContentType(ContentType.APPLICATION_JSON);
            builder.setText(param);
            post.setEntity(builder.build());

            CloseableHttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();

            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            logger.info("状态:" + statusCode + "数据:" + data);
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                client.close();
            } catch (Exception ex) {
            }
        }
    }

    /**
     * 发送 POST 请求，参数为 JSONObject，返回结果为 JSONObject
     *
     * @param url       请求地址
     * @param jsonParam 请求体参数
     * @return 响应结果（JSONObject）
     */
    public static JSONObject httpPost(String url, JSONObject jsonParam) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpPost post = new HttpPost(url);
            post.setConfig(REQUEST_CONFIG);

            // 构建 JSON 请求体
            EntityBuilder builder = EntityBuilder.create();
            builder.setContentType(ContentType.APPLICATION_JSON);
            builder.setText(jsonParam.toJSONString());
            post.setEntity(builder.build());

            // 执行请求
            CloseableHttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();

            HttpEntity entity = response.getEntity();
            String data = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            logger.info("状态:" + statusCode + "，数据:" + data);

            if (statusCode != SC_OK) {
                throw new RuntimeException("POST 请求失败，状态码：" + statusCode + "，响应：" + data);
            }

            return JSONObject.parseObject(data);
        } catch (Exception e) {
            logger.error("POST 请求异常", e);
            throw new RuntimeException("POST 请求异常：" + e.getMessage());
        } finally {
            try {
                client.close();
            } catch (IOException ex) {
                logger.error("关闭 HttpClient 异常", ex);
            }
        }
    }

}
