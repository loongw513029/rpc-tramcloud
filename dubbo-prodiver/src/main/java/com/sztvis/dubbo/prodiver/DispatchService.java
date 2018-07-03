package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.domain.TramDispatchInfo;
import com.sztvis.dubbo.IDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/25 上午9:15
 */
@Service(version = "1.0.0")
public class DispatchService implements IDispatchService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void insertDispatchInfo(TramDispatchInfo dispatchInfo) {
        this.mongoTemplate.save(dispatchInfo);
    }

    @Override
    public TramDispatchInfo getLastDispatchInfo(long deviceId) {
        Query query = new Query();
        query.addCriteria(new Criteria("deviceid").is(deviceId));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"updatetime")));
        return this.mongoTemplate.findOne(query,TramDispatchInfo.class);
    }

}
