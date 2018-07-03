package com.sztvis.domain.baiduAI.Req;

public class FaceRegisterRequestModel {
    private String uid;//用户id，由数字，字母下户线组成，长度128B，user_1
    private String group_id;//用户组，可按机构划分 group_1
    private String image;//base64编码后的图片数据，需urlencode,z支持单张，<10M
    private String user_info;//用户资料，填姓名
    private String action_type = "replace";//

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }
}
