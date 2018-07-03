package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.domain.dto.WorkOrderViewModel;
import com.sztvis.dubbo.IWorkOrderService;
import com.sztvis.dubbo.prodiver.mapper.DeviceMapper;
import com.sztvis.dubbo.prodiver.mapper.MemberMapper;
import com.sztvis.dubbo.prodiver.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class WorkOrderService implements IWorkOrderService {

    @Autowired
    private MemberMapper iMemberMapper;
    @Autowired
    private WorkOrderMapper iWorkOrderMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<WorkOrderViewModel> GetWorkOrders(String code, String start, String end)
    {
        return this.iWorkOrderMapper.GetWorkOrders(code,start,end);
    }
}
