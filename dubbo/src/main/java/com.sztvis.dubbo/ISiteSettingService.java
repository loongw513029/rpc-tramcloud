package com.sztvis.dubbo;


import com.sztvis.domain.dto.SiteSettingsInfo;
import com.sztvis.domain.dto.service.ChartViewModel;

public interface ISiteSettingService {
    ChartViewModel GetAppCharts(long userId, long lineId);

    SiteSettingsInfo GetSiteSettings() throws Exception;

    void SaveSetting(String key, Object value);

    SiteSettingsInfo GetSave();
}
