package com.sztvis.domain.dto;

import java.io.Serializable;
import java.util.List;

public class AppHomeViewModel implements Serializable{
    private List<AppSelectViewModel> Lines;

    public List<AppSelectViewModel> getLines() {
        return Lines;
    }

    public void setLines(List<AppSelectViewModel> lines) {
        Lines = lines;
    }
}
