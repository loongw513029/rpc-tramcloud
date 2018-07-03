package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.core.DateUtil;
import com.sztvis.domain.domain.TramDeviceInfo;
import com.sztvis.dubbo.IDeviceService;
import com.sztvis.dubbo.IFlowService;
import com.sztvis.dubbo.prodiver.mapper.FlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.List;

@Service(version = "1.0.0")
public class FlowService implements IFlowService {
    @Value("${videourl}")
    private String videourl;
    @Reference(version = "1.0.0")
    private IDeviceService ideviceService;
    @Autowired
    private FlowMapper flowMapper;

    @Override
    public void SensusAlarmVideo(){
        String url = videourl;
        List<String> codes = this.ideviceService.GetAllCarCodes(null);
        String now = DateUtil.getCurrentTime();
        String time = DateUtil.addDay(now,-1);
        for (String code : codes){
            TramDeviceInfo deviceInfo = this.ideviceService.GetDriverInfo(0,code);
            List<String> paths = this.flowMapper.GetCanPath(code,time,now);
            long size = 0;
            for (String path : paths){
                String filePath = url + path;
                File file = new File(filePath);
                if (file!=null)
                    size += file.length();
            }
            if (size!=0)
                this.flowMapper.UpdateHostFlowCensus(size,deviceInfo.getId(),time);
        }
    }
}
