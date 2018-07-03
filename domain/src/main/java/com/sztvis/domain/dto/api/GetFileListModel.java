package com.sztvis.domain.dto.api;


import java.io.Serializable;

public class GetFileListModel implements Serializable {
    private String time;
    private int channel;
    private String category;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
