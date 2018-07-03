package com.sztvis.domain.dto;

import java.io.Serializable;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/25 上午8:53
 */
public class DispatchViewModel implements Serializable {
    private String CurrentSite;
    private String NextSite;
    private int InOrOutSite;
    private int InOrOutSiteType;
    private int SiteType;

    public String getCurrentSite() {
        return CurrentSite;
    }

    public void setCurrentSite(String currentSite) {
        CurrentSite = currentSite;
    }

    public String getNextSite() {
        return NextSite;
    }

    public void setNextSite(String nextSite) {
        NextSite = nextSite;
    }

    public int getInOrOutSite() {
        return InOrOutSite;
    }

    public void setInOrOutSite(int inOrOutSite) {
        InOrOutSite = inOrOutSite;
    }

    public int getInOrOutSiteType() {
        return InOrOutSiteType;
    }

    public void setInOrOutSiteType(int inOrOutSiteType) {
        InOrOutSiteType = inOrOutSiteType;
    }

    public int getSiteType() {
        return SiteType;
    }

    public void setSiteType(int siteType) {
        SiteType = siteType;
    }
}
