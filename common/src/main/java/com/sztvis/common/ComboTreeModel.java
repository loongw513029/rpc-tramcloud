package com.sztvis.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/17 下午1:40
 */
public class ComboTreeModel implements Serializable{
    private int id;
    private String text;
    private boolean checked = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ComboTreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<ComboTreeModel> children) {
        this.children = children;
    }

    private List<ComboTreeModel> children;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
