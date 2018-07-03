package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.dto.MaintenanceInfo;
import com.sztvis.dubbo.IBasicService;
import com.sztvis.dubbo.IMaintenanceService;
import com.sztvis.dubbo.prodiver.mapper.MaintenanceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class MaintenanceService implements IMaintenanceService {

    @Reference(version = "1.0.0")
    private IBasicService iBasicService;
    @Autowired
    private MaintenanceMapper maintenanceMapper;

    @Override
    public List<MaintenanceInfo> GetCurrentAccountsMaintenanceList(long userId)
    {
        List<Long> deviceIds=this.iBasicService.getDeviceIdsByRoleLv(userId);
        return this.maintenanceMapper.GetCurrentAccountsMaintenanceList(StringHelper.getLists(deviceIds.toString()));
    }

    @Override
    public List<MaintenanceInfo> GetMaintenanceInfo(String Code,long DepartmentId,long lineId,String start,String end){
        return this.maintenanceMapper.GetMaintenance(Code,DepartmentId,lineId,start,end);}

    @Override
    public List<MaintenanceInfo> getTop8Maintenaces() {
        return this.maintenanceMapper.getTop6List();
    }

    @Override
    public void AddMaintenanceInfo(MaintenanceInfo maintenanceInfo)
    {
        this.maintenanceMapper.AddMaintenanceInfo(maintenanceInfo);
    }
}
