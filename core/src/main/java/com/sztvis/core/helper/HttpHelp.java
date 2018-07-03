package com.sztvis.core.helper;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class HttpHelp {
    // UTF-8字符编码
    public static final String CHARSET_UTF_8 ="UTF-8";
    // HTTP内容类型
    public static final String CONTENE_TYPE_TEXT_HTML = "text/xml";
    // HTTP内容类型。相当于form表单的形式，提交数据
    public static final String CONTENT_TYPE_FORM_URL = "application/x-www-form-urlencoded";
    // HTTP内容类型。相当于form表单的形式，提交数据
    public static final String CONTENT_TYPE_JSON_URL = "application/json;charset=UTF-8";

    //链接管理器
    private static PoolingHttpClientConnectionManager pool;
    //请求配置
    private static RequestConfig requestConfig;

    static {
        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create(
            ).register("http", PlainConnectionSocketFactory.getSocketFactory()
            ).register("https", sslsf).build();   //配置同时支持http和https
            pool = new PoolingHttpClientConnectionManager(socketFactoryRegistry);   //初始化连接管理器
            pool.setMaxTotal(200);   //将最大连接数增加到200
            pool.setDefaultMaxPerRoute(2);   //设置最大路由
            int socketTimeout = 10000;
            int connectTimeout = 10000;
            int connetionRequestTimeout = 10000;
            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(connetionRequestTimeout).setSocketTimeout(socketTimeout)
                    .setConnectTimeout(connectTimeout).build();   //根据默认超时限制初始化requestConfig
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        //设置请求超时时间
        requestConfig = RequestConfig.custom().setConnectTimeout(50000).setSocketTimeout(50000).setConnectionRequestTimeout(50000).build();
    }

    public static CloseableHttpClient getHttpClient(){
        CloseableHttpClient httpClient = HttpClients.custom()
        .setConnectionManager(pool)   //设置连接池管理
        .setDefaultRequestConfig(requestConfig)   //设置请求配置
        .setRetryHandler(new DefaultHttpRequestRetryHandler(0,false))   //设置重试次数
        .build();
        return httpClient;
    }

    public HttpHelp() {
    }

    /**
      * 发送Post请求
      *
      * @param httpPost
      * @return
      */

    private static String sendHttpPost(HttpPost httpPost)
    {
        CloseableHttpClient httpClient=null;
        CloseableHttpResponse response=null;
        String responseContent=null;
        try {
            httpClient = getHttpClient();   //创建默认的httpClient实例
            httpPost.setConfig(requestConfig);   //配置请求信息
            response = httpClient.execute(httpPost);   //执行请求
            HttpEntity entity = response.getEntity();   //得到响应实例
            if (response.getStatusLine().getStatusCode()>=300){
                throw new Exception("Http请求不成功!错误码："+ response.getStatusLine().getStatusCode());
            }
            if (response.getStatusLine().getStatusCode()==200){
                responseContent = EntityUtils.toString(entity,CHARSET_UTF_8);
                EntityUtils.consume(entity);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if (response!=null){   //释放资源
                    response.close();;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
     * 发送Delete请求
     * @param httpDelete
     * @return
     */
    private static String sendHttpDelete(HttpDelete httpDelete)
    {
        CloseableHttpClient httpClient=null;
        CloseableHttpResponse response=null;
        String responseContent=null;
        try {
            httpClient = getHttpClient();   //创建默认的httpClient实例
            httpDelete.setConfig(requestConfig);   //配置请求信息
            response = httpClient.execute(httpDelete);   //执行请求
            HttpEntity entity = response.getEntity();   //得到响应实例
            if (response.getStatusLine().getStatusCode()>=300){
                throw new Exception("Http请求不成功!错误码："+ response.getStatusLine().getStatusCode());
            }
            if (response.getStatusLine().getStatusCode()==200){
                responseContent = EntityUtils.toString(entity,CHARSET_UTF_8);
                EntityUtils.consume(entity);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if (response!=null){   //释放资源
                    response.close();;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
     * 发送Patch请求
     * @param httpPatch
     * @return
     */
    private static String sendHttpPatch(HttpPatch httpPatch)
    {
        CloseableHttpClient httpClient=null;
        CloseableHttpResponse response=null;
        String responseContent=null;
        try {
            httpClient = getHttpClient();   //创建默认的httpClient实例
            httpPatch.setConfig(requestConfig);   //配置请求信息
            response = httpClient.execute(httpPatch);   //执行请求
            HttpEntity entity = response.getEntity();   //得到响应实例
            if (response.getStatusLine().getStatusCode()>=300){
                throw new Exception("Http请求不成功!错误码："+ response.getStatusLine().getStatusCode());
            }
            if (response.getStatusLine().getStatusCode()==200){
                responseContent = EntityUtils.toString(entity,CHARSET_UTF_8);
                EntityUtils.consume(entity);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if (response!=null){   //释放资源
                    response.close();;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
    /**
     * 发送Post请求
     *
     * @param httpGet
     * @return
     */
    private static String sendHttpGet(HttpGet httpGet)
    {
        CloseableHttpClient httpClient=null;
        CloseableHttpResponse response=null;
        String responseContent=null;
        try {
            httpClient = getHttpClient();   //创建默认的httpClient实例
            httpGet.setConfig(requestConfig);   //配置请求信息
            response = httpClient.execute(httpGet);   //执行请求
            HttpEntity entity = response.getEntity();   //得到响应实例
            if (response.getStatusLine().getStatusCode()>=300){
                throw new Exception("Http请求不成功!错误码："+ response.getStatusLine().getStatusCode());
            }
            if (response.getStatusLine().getStatusCode()==200){
                responseContent = EntityUtils.toString(entity,CHARSET_UTF_8);
                EntityUtils.consume(entity);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if (response!=null){   //释放资源
                    response.close();;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
      * 发送 post请求
      *
      * @param httpUrl
      *            地址
      * @param paramsJson
      *            参数(格式:json)
      *
      */
    public static String sendHttpPostJson(String httpUrl, String paramsJson) {
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
        try {
            String Timestamp=String.valueOf((new  Date().getTime())-
                    (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
                    .parse("1970-01-01 00:00:00:000").getTime()));
            String Sign= SecureHelper.encryptToMD5(String.valueOf(LocalDate.now().getYear())+
            "fsafa#*&*sfBDSAwcx"+String.valueOf(LocalDate.now().getMonth())+String.valueOf(LocalDate.now().getDayOfMonth()+
            Timestamp)).toLowerCase();
            // 设置参数
            if (paramsJson != null && paramsJson.trim().length() > 0) {
                StringEntity stringEntity = new StringEntity(paramsJson, "UTF-8");
                stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
                httpPost.setHeader("ContentType",CONTENT_TYPE_JSON_URL);
                httpPost.setHeader("apiUserCode","tvis");
                httpPost.setHeader("timestamp",Timestamp);
                httpPost.setHeader("sign",Sign);
                httpPost.setEntity(stringEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }

    public static String sendBaiduAiHttp(String url,String json){
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        try {
           StringEntity stringEntity = new StringEntity(json, "UTF-8");
           stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
           httpPost.setHeader("ContentType",CONTENT_TYPE_JSON_URL);
           httpPost.setEntity(stringEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }


    public static String sendHttpGet(String httpUrl) {
         // 创建get请求
         HttpGet httpGet = new HttpGet(httpUrl);
         return sendHttpGet(httpGet);
     }

     public static String sendHttp(String httpUrl,String jsonStr,String method){
         String result ="";
         switch (method.toLowerCase()) {
             case "get":
                 result = sendHttpGet(httpUrl);
                 break;
             case "post":
                 if (jsonStr != null && jsonStr.trim().length() > 0) {
                     HttpPost httpPost = new HttpPost(httpUrl);
                     StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
                     stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
                     httpPost.setEntity(stringEntity);
                     result = sendHttpPost(httpPost);
                 }
                 break;
             case "patch":
                 if (jsonStr != null && jsonStr.trim().length() > 0) {
                     HttpPatch httpPatch = new HttpPatch(httpUrl);
                     StringEntity stringEntity = new StringEntity(jsonStr, "UTF-8");
                     stringEntity.setContentType(CONTENT_TYPE_JSON_URL);
                     httpPatch.setEntity(stringEntity);
                     result = sendHttpPatch(httpPatch);
                 }
                 break;
             case "delete":
                 HttpDelete httpDelete = new HttpDelete(httpUrl);
                 result = sendHttpDelete(httpDelete);
                 break;

         }
         return result;
     }

}

