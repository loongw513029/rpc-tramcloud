package com.sztvis.dubbo;


import com.sztvis.domain.UnSafeListViewModel;
import com.sztvis.domain.UnSafeQuery;

import java.util.List;

public interface IUnSafeService {
    List<UnSafeListViewModel> GetUnsafeList(UnSafeQuery query);

    void CalcUnsafeIndex() throws Exception;
}
