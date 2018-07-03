package com.sztvis.dubbo.prodiver;


import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.domain.OneKeyInspectRecords;
import com.sztvis.dubbo.IInspectService;
import com.sztvis.dubbo.prodiver.mapper.InspectMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/29 上午11:09
 */
@Service(version = "1.0.0")
public class InspectService implements IInspectService {

    @Autowired
    private InspectMapper inspectMapper;
    public void insertOneKeyInspectRecords(OneKeyInspectRecords oneKeyInspectRecords) {
        this.inspectMapper.insertInspectRecords(oneKeyInspectRecords);
    }
}
