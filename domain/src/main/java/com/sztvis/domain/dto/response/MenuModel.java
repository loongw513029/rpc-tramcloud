package com.sztvis.domain.dto.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/29 下午1:08
 */
public class MenuModel implements Serializable {
    private String text;
    private String glyph;
    private String cls;
    private String uri;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGlyph() {
        return glyph;
    }

    public void setGlyph(String glyph) {
        this.glyph = glyph;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<MenuModel> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuModel> menu) {
        this.menu = menu;
    }

    private List<MenuModel> menu;
}