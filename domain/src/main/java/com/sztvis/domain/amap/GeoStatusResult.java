package com.sztvis.domain.amap;

import java.util.List;

public class GeoStatusResult {
    private String errcode;
    private String errmsg;
    private Data data;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        private String status;
        private String nearest_fence_distance;
        private String nearest_fence_gid;
        private List<FenceEventList> fencing_event_list;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getNearest_fence_distance() {
            return nearest_fence_distance;
        }

        public void setNearest_fence_distance(String nearest_fence_distance) {
            this.nearest_fence_distance = nearest_fence_distance;
        }

        public String getNearest_fence_gid() {
            return nearest_fence_gid;
        }

        public void setNearest_fence_gid(String nearest_fence_gid) {
            this.nearest_fence_gid = nearest_fence_gid;
        }

        public List<FenceEventList> getFencing_event_list() {
            return fencing_event_list;
        }

        public void setFencing_event_list(List<FenceEventList> fencing_event_list) {
            this.fencing_event_list = fencing_event_list;
        }

        public static  class FenceEventList{
            private String client_action;
            private String client_status;
            private String enter_time;
            private FenceInfo fence_info;

            public String getClient_action() {
                return client_action;
            }

            public void setClient_action(String client_action) {
                this.client_action = client_action;
            }

            public String getClient_status() {
                return client_status;
            }

            public void setClient_status(String client_status) {
                this.client_status = client_status;
            }

            public String getEnter_time() {
                return enter_time;
            }

            public void setEnter_time(String enter_time) {
                this.enter_time = enter_time;
            }

            public FenceInfo getFence_info() {
                return fence_info;
            }

            public void setFence_info(FenceInfo fence_info) {
                this.fence_info = fence_info;
            }

            private static class FenceInfo{
                private String fence_gid;
                private String fence_name;

                public String getFence_gid() {
                    return fence_gid;
                }

                public void setFence_gid(String fence_gid) {
                    this.fence_gid = fence_gid;
                }

                public String getFence_name() {
                    return fence_name;
                }

                public void setFence_name(String fence_name) {
                    this.fence_name = fence_name;
                }
            }
        }
    }
}
