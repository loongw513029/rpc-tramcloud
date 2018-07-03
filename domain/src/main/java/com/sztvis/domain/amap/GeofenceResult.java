package com.sztvis.domain.amap;

public class GeofenceResult {
    private int errcode;
    private String errmsg;
    private GeofenceModel data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public GeofenceModel getData() {
        return data;
    }

    public void setData(GeofenceModel data) {
        this.data = data;
    }

    public static class GeofenceModel{
        private String gid;
        private String id;
        private String message;
        private String status;

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
