package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.sztvis.core.helper.HttpHelp;
import com.sztvis.domain.baiduAI.Req.ComparisonReqModel;
import com.sztvis.domain.baiduAI.Req.FaceRegisterRequestModel;
import com.sztvis.domain.baiduAI.Req.GetTokenRequestModel;
import com.sztvis.domain.baiduAI.Resp.ComparisonRespModel;
import com.sztvis.domain.baiduAI.Resp.FaceRegisterRespModel;
import com.sztvis.domain.baiduAI.Resp.GetTokenResult;
import com.sztvis.dubbo.IBaiduAIService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "1.0.0")
public class BaiduAIService implements IBaiduAIService {

    @Value("baiduai.appid")
    private String appid;
    @Value("baiduai.api_key")
    private String api_key;
    @Value("baiduai.secret_key")
    private String secret_key;
    @Override
    public GetTokenResult getToken() throws Exception {
        String result ="";
        GetTokenRequestModel model = new GetTokenRequestModel();
        model.setClient_id(api_key);
        model.setClient_secret(secret_key);
        result = HttpHelp.sendBaiduAiHttp("https://aip.baidubce.com/oauth/2.0/token", JSON.toJSONString(model));
        return JSON.parseObject(result,GetTokenResult.class);
    }

    @Override
    public FaceRegisterRespModel addUser(String uid, String groupid, String userinfo, String base64Str) throws Exception {
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/add?access_token="+getToken().getAccess_token();
        FaceRegisterRequestModel model = new FaceRegisterRequestModel();
        model.setGroup_id(groupid);
        model.setUid(uid);
        model.setUser_info(userinfo);
        model.setImage(base64Str);
        String result = HttpHelp.sendBaiduAiHttp(url,JSON.toJSONString(model));
        return JSON.parseObject(result,FaceRegisterRespModel.class);
    }

    @Override
    public ComparisonRespModel Comparison(String base64Str, String groupId) throws Exception {
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/identify?access_token="+getToken().getAccess_token();
        ComparisonReqModel model =new ComparisonReqModel();
        model.setGroup_id(groupId);
        model.setImage(base64Str);
        String result = HttpHelp.sendBaiduAiHttp(url,JSON.toJSONString(model));
        return JSON.parseObject(result,ComparisonRespModel.class);
    }

}
