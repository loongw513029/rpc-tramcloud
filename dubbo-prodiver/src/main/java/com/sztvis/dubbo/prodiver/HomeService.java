package com.sztvis.dubbo.prodiver;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;
import com.sztvis.core.DayTypes;
import com.sztvis.domain.domain.TramBasicInfo;
import com.sztvis.domain.dto.WelcomeModel;
import com.sztvis.domain.dto.WelcomeTrendModel;
import com.sztvis.dubbo.IAlarmService;
import com.sztvis.dubbo.IDepartmentService;
import com.sztvis.dubbo.IDeviceService;
import com.sztvis.dubbo.IHomeService;
import com.sztvis.dubbo.prodiver.mapper.BasicMapper;
import com.sztvis.dubbo.prodiver.mapper.CanMapper;
import com.sztvis.dubbo.prodiver.mapper.DeviceMapper;
import com.sztvis.dubbo.prodiver.mapper.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/9 上午9:49
 */
@Service(version = "1.0.0")
public class HomeService implements IHomeService {

    @Autowired
    private DeviceMapper deviceMapper;
    @Reference(version = "1.0.0")
    private IDepartmentService departmentService;
    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private BasicMapper basicMapper;
    @Autowired
    private CanMapper canMapper;
    @Reference(version = "1.0.0")
    private IAlarmService iAlarmService;
    @Reference(version = "1.0.0")
    private IDeviceService iDeviceService;
    @Override
    public WelcomeModel GetWelcomeData(long userId) {
        WelcomeModel model =new WelcomeModel();
        List<Long> departmentIds = departmentService.GetDepartmentIdsByUserId(userId);
        List<Long> devices = this.iDeviceService.getDeviceIdsByUserId(userId);
        Integer deviceNum = deviceMapper.getDeviceCount(0,departmentIds);
        Integer onlineNum = deviceMapper.getRealTimeOnlineCount(devices);
        model.setTotelNum(deviceNum);
        model.setOnlineNum(onlineNum);
        model.setLineNum(lineMapper.GetLineIdsByDepartmentIds(departmentIds));
        Integer todayNum = deviceMapper.getOnlinePrecent(departmentIds, DateUtil.GetSystemDate("yyyy-MM-dd",0));
        Integer fiveNum = deviceMapper.getOnlinePrecent(departmentIds,DateUtil.GetSystemDate("yyyy-MM-dd",-5));
        float todayPrecent = (float)todayNum/(float)deviceNum,
                fivePrecent = (float)fiveNum/(float)deviceNum;
        model.setTodayPrecent((int)(todayPrecent*100));
        model.setFiveDayPrecent((int)(fivePrecent*100));
        Integer unsafeNum = deviceMapper.getUnSafeCountByDepartmentIds(departmentIds,DateUtil.GetSystemDate("yyyy-MM-dd",0));
        model.setUnsafeNum(unsafeNum);
        model.setAlarmList(this.iAlarmService.getTop6HomePageAlarms(userId));
        return model;
    }

    @Override
    public WelcomeTrendModel getWelcomeTrendModels(long userId) {
        WelcomeTrendModel welcomeTrendModel =new WelcomeTrendModel();
        DayTypes dayTypes = new DayTypes().getDayByType(2);
        int day = 0;
        try {
           day = DateUtil.daysBetween(dayTypes.getStartTime(), dayTypes.getEndTime(), DateStyle.YYYY_MM_DD);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> xalis = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();
        List<String> faultXalias = new ArrayList<>();
        int p=0;
        for (TramBasicInfo b:this.basicMapper.getAlarmTypes(1)) {
            faultXalias.add(b.getAlarmName());
            List<Integer> list1s = new ArrayList<>();
            for(int i=0;i<day;i++){
                String start = DateUtil.addDay(dayTypes.getStartTime(),i),
                        end = DateUtil.addDay(start,1);
                if(p==0) {
                    xalis.add(start.split("-")[2] + "日");
                }
                int count = this.iAlarmService.getAlarmTrendsCounts(userId,start,end,Integer.valueOf(b.getCustomId()));
                list1s.add(count);
            }
            p++;
            list1.add(list1s);
        }
        welcomeTrendModel.setXalias(xalis);
        welcomeTrendModel.setFaultXalias(faultXalias);
        welcomeTrendModel.setFaults(list1);
        List<List<Integer>> list2 = new ArrayList<>();
        List<String> unsafeXalias = new ArrayList<>();
        for (TramBasicInfo b:this.basicMapper.getAlarmTypes(78)) {
            unsafeXalias.add(b.getAlarmName());
            List<Integer> list2s = new ArrayList<>();
            for(int i=0;i<day;i++){
                String start = DateUtil.addDay(dayTypes.getStartTime(),i),
                        end = DateUtil.addDay(start,1);
                int count = this.iAlarmService.getAlarmTrendsCounts(userId,start,end,Integer.valueOf(b.getCustomId()));
                list2s.add(count);
            }
            list2.add(list2s);
        }
        welcomeTrendModel.setUnsafeXalias(unsafeXalias);
        welcomeTrendModel.setUnsafes(list2);
        return  welcomeTrendModel;
    }

    @Override
    public int getTodayAlarmCount(long userId) {
        return this.iAlarmService.getTodayAlarmCount(userId);
    }
}
