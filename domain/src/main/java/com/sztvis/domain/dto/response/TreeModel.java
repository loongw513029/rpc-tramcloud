package com.sztvis.domain.dto.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/4 上午11:44
 */
public class TreeModel implements Serializable{

    private long id;
    private String text;
    private String iconCls;
    private String state;
    private boolean edit;
    private boolean checked;
    private TreeAttributeModel attributes;
    private List<TreeModel> children;

    public long getId() {
        return id;
    }
      public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public TreeAttributeModel getAttributes() {
        return attributes;
    }

    public void setAttributes(TreeAttributeModel attributes) {
        this.attributes = attributes;
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
