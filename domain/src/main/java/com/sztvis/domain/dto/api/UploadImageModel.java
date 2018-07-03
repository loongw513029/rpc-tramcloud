package com.sztvis.domain.dto.api;

import java.io.Serializable;
import java.util.List;

public class UploadImageModel implements Serializable {
    private String identity;
    private List<String> images;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
