package com.sztvis.dubbo;


import com.sztvis.domain.DataAlarmConfigViewModel;

public interface IConfigService {
    DataAlarmConfigViewModel GetAllConfigs()throws Exception;
}
