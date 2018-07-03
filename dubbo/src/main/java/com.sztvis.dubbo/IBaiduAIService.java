package com.sztvis.dubbo;


import com.sztvis.domain.baiduAI.Resp.ComparisonRespModel;
import com.sztvis.domain.baiduAI.Resp.FaceRegisterRespModel;
import com.sztvis.domain.baiduAI.Resp.GetTokenResult;

public interface IBaiduAIService {
    /**
     * 1.获得Token
     * @return
     */
    GetTokenResult getToken() throws Exception;

    /**
     * 人脸注册
     * @param uid
     * @param groupid
     * @param userinfo
     * @param base64Str
     * @return
     */
    FaceRegisterRespModel addUser(String uid, String groupid, String userinfo, String base64Str) throws Exception;

    /**
     * 人脸比对
     * @param base64Str 图片
     * @param groupId 要比对的组
     * @return
     * @throws Exception
     */
    ComparisonRespModel Comparison(String base64Str, String groupId) throws Exception;


}
