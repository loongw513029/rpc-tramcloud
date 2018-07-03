package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/16 上午10:33
 */
public class EasyDataGridResult implements Serializable{
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    private int total;
    private Object rows;
}
