package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.domain.TramDriverInfo;
import com.sztvis.domain.dto.DriverViewModel;
import com.sztvis.dubbo.IDriverService;
import com.sztvis.dubbo.prodiver.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(version = "1.0.0")
public class DriverService implements IDriverService {
    @Autowired
    private DriverMapper driverMapper;
    @Override
    public List<DriverViewModel> getDriverList(String driverName, long departmentId, int offset, int limit) {
        List<DriverViewModel> list = this.driverMapper.getDriverList(driverName,departmentId,offset,limit);
        return list;
    }

    @Override
    public int getDriverListCount(String driverName, long departmentId) {
        return this.driverMapper.getDriverListCount(driverName,departmentId);
    }

    @Override
    public TramDriverInfo getDriverInfo(long id) {
        return this.driverMapper.getDriverInfo(id);
    }

    @Override
    public void SaveAndUpdateDriver(TramDriverInfo driverInfo) {
        if(driverInfo.getId() == 0)
            this.driverMapper.InsertDriverInfo(driverInfo);
        else
            this.driverMapper.UpdateDriverInfo(driverInfo);
    }

    @Override
    public void RemoveDrivers(List<String> ids) {
        this.driverMapper.RemoveDrivers(ids);
    }

}
