package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.dto.SiteSettingViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.SiteSettingProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SiteSettingMapper {
    @SelectProvider(type = SiteSettingProvider.class,method = "GetAppCharts")
    int GetAppCharts(int type, List<Long> LineArr, Long lineId, String date, String date2);

    @Select("select * from TramSiteSettingInfo")
    List<SiteSettingViewModel> GetSiteSettings();

    @Select("select * from TramSiteSettingInfo where `Key`=#{key}")
    Map<String,Object> GetGetSiteSettingsKey(@Param("key") String key);

    @Insert("insert into TramSiteSettingInfo values(default,#{key},#{value})")
    void InsertSaveSetting(@Param("key") String key, @Param("value") Object value);

    @Update("update TramSiteSettingInfo set Value=#{value} where `Key`=#{key}")
    void updateSaveSetting(@Param("key") String key, @Param("value") Object value);

    @Select("select `key` from TramSiteSettingInfo")
    List<String> GetSavekey();

    @Select("select value from TramSiteSettingInfo")
    List<Object> GetSavevalue();
}
