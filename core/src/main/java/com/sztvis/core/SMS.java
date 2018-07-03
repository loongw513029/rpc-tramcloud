package com.sztvis.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sztvis.core.helper.SecureHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/23 下午4:34
 */
public class SMS {
    public static String LOGIN_URL;
    public static String Authorization;
    // http客户端
    public static DefaultHttpClient httpclient;

    public static HttpPost getPostMethod(String url){
        HttpPost pmethod = new HttpPost(url); // 设置响应头信息
        pmethod.addHeader("Accept", "application/json");
        // Content-Type application/x-www-form-urlencoded; charset=UTF-8
        pmethod.addHeader("Content-Type", "application/json; charset=UTF-8");
        // Host mp.weixin.qq.com
        pmethod.addHeader("Host", "app.cloopen.com:8883");
        // X-Requested-With XMLHttpRequest
        pmethod.addHeader("Authorization", Authorization);
        return pmethod;
    }


    static {
        httpclient = new DefaultHttpClient();
        //httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String datestr = format.format(date);
        String sig = SecureHelper.encryptToMD5(
                "{accountSid}{appid}"
                        + datestr).toUpperCase();
        LOGIN_URL = "https://app.cloopen.com:8883/2013-12-26/Accounts/{accountSid}/SMS/TemplateSMS?sig="
                + sig;

        Authorization=encodeStr("{accountSid}:"+datestr);

    }
    /**
     *
     * 创建日期2011-4-25上午10:12:38
     * 修改日期
     * 作者：dh *
     *return
     */
    public static String encodeStr(String plainText){
        byte[] b=plainText.getBytes();
        Base64.Encoder encoder=Base64.getEncoder();
        return encoder.encodeToString(b);
    }

    /**
     *  发送非模板短信
     * @param args
     * @author: Jerri Liu
     * @date: 2014年3月19日下午2:28:42
     */
    public static boolean sendMsg(Object phoneNumber,Object captcha){
        HttpPost httpost = getPostMethod(LOGIN_URL);
        String s = "{\"to\":\""+phoneNumber+"\",\"body\":\""+captcha+"\",\"msgType\":\"0\",\"appId\":\"{appid}\",\"subAccountSid\":\"{subAccountSid}\"}";
        httpost.setEntity(new StringEntity(s, "UTF-8"));
        try {
            httpclient.execute(httpost);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     *  发送模板短信
     * @param phoneNumber 电话号
     * @author: Jerri Liu
     * @date: 2014年3月19日下午2:28:42
     */
    public static String sendTemplateMsg(Object phoneNumber,Object captcha){
        try {
            HttpPost httpost = getPostMethod(LOGIN_URL);
            String s = "{\"to\":\""+phoneNumber+"\"appId\":\"{appid}\",\"templateId\":\"1\",\"datas\":[\""+captcha+"\",\"3\"]}";
            httpost.setEntity(new StringEntity(s, "UTF-8"));
            HttpResponse response = httpclient.execute(httpost);
            String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(jsonStr);
            JSONObject object = JSON.parseObject(jsonStr);
            return object.getString("errmsg");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
