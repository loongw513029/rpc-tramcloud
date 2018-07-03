package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.dto.WorkOrderViewModel;
import com.sztvis.dubbo.prodiver.mapper.provider.WorkOrderProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface WorkOrderMapper {
    @SelectProvider(type = WorkOrderProvider.class,method = "GetWorkOrdersSQL")
    List<WorkOrderViewModel> GetWorkOrders(@Param("code") String code, @Param("start") String start, @Param("end") String end);
}
