package com.sztvis.dubbo;


import com.sztvis.domain.dto.WorkOrderViewModel;

import java.util.List;

public interface IWorkOrderService {
    List<WorkOrderViewModel> GetWorkOrders(String code, String start, String end);
}
