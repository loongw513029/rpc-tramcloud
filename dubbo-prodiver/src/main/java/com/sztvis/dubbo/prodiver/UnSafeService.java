package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.common.entity.CanAlarmTypes;
import com.sztvis.core.DateUtil;
import com.sztvis.core.DayTypes;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.IndexModel;
import com.sztvis.domain.UnSafeListViewModel;
import com.sztvis.domain.UnSafeQuery;
import com.sztvis.domain.domain.TramDriverInfo;
import com.sztvis.domain.domain.TramMemberInfo;
import com.sztvis.domain.dto.CurrentUserInfo;
import com.sztvis.dubbo.IDeviceService;
import com.sztvis.dubbo.IMemberService;
import com.sztvis.dubbo.ISiteSettingService;
import com.sztvis.dubbo.IUnSafeService;
import com.sztvis.dubbo.prodiver.mapper.DriverMapper;
import com.sztvis.dubbo.prodiver.mapper.UnSafeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service(version = "1.0.0")
public class UnSafeService implements IUnSafeService {

    @Reference(version = "1.0.0")
    private IMemberService iMemberService;
    @Reference(version = "1.0.0")
    private IDeviceService iDeviceService;
    @Autowired
    private UnSafeMapper unSafeMapper;
    @Reference(version = "1.0.0")
    private ISiteSettingService iSiteSettingService;
    @Autowired
    private DriverMapper driverMapper;

    @Override
    public List<UnSafeListViewModel> GetUnsafeList(UnSafeQuery query)
    {
        List<Long> deviceIds=new ArrayList<>();
         if(StringHelper.isNotEmpty(query.getUserId()))
         {
             TramMemberInfo info=this.iMemberService.getMemberInfo(query.getUserId());
             CurrentUserInfo user=new CurrentUserInfo();
             user.setUserName(info.getUsername());
             user.setDepartmentId(info.getOwnershipid());
             deviceIds=this.iDeviceService.GetDeviceIdsByDepartmentId(user);
         }
        DayTypes types=DayTypes.getDayByType(query.getDayType());
        return this.unSafeMapper.GetUnsafeList(query,deviceIds,types);
    }

    @Override
    public void CalcUnsafeIndex() throws Exception {
        List<String> key = new ArrayList<>();
        key.add("IndexUnit");
        int IndexUnit = this.iSiteSettingService.GetSiteSettings().getIndexUnit();
        String now = DateUtil.getCurrentTime();
        if (IndexUnit > 0){
            List<TramDriverInfo> drivers=this.driverMapper.getDrivers();
            for (TramDriverInfo item : drivers){
                List<String> codes = this.driverMapper.GetDeviceCodeByDriverId(item.getId());
                String lastTime = this.unSafeMapper.GetlastTime(item.getId());
                switch(IndexUnit){
                    case 1:
                        lastTime = DateUtil.addDay(lastTime,1);
                        break;
                    case 2:
                        lastTime = DateUtil.addDay(lastTime,7);
                        break;
                    case 3:
                        lastTime = DateUtil.addMonth(lastTime,1);
                        break;
                }
                if (DateUtil.getIntervalDays(now,lastTime) >= 0){
                    String start = DateUtil.addDay(now,-1);
                    String end = now;
                    List<IndexModel> extras = this.unSafeMapper.GetCanExtras(codes,new int[]{CanAlarmTypes.FaceBumpAlarm.getValue()},start,end);
                    List<IndexModel> arr = extras.stream().filter(s -> !StringHelper.isNotEmpty(s.getExtras())).collect(Collectors.toList());
                    arr.forEach(x ->{
                        x.setSpeed(Double.parseDouble(x.getExtras().split("|")[0]));
                    });
                    int F8 = (int)arr.stream().filter(s -> s.getSpeed() >= 80).count();
                    int F7 = (int)arr.stream().filter(s -> s.getSpeed() >= 30 && s.getSpeed() < 80).count();
                    List<IndexModel> extras2 = this.unSafeMapper.GetCanExtras(codes,new int[]{CanAlarmTypes.LowSpeedBump.getValue()},start,end);
                    List<IndexModel> arr2 = extras2.stream().filter(s -> !StringHelper.isNotEmpty(s.getExtras())).collect(Collectors.toList());
                    arr2.forEach(x ->{
                        x.setSpeed(Double.parseDouble(x.getExtras().split("|")[0]));
                    });
                    int F6 = (int)arr2.stream().filter(s -> s.getSpeed() < 30).count();
                    int[] keyarr = new int[]{ CanAlarmTypes.RollLeftRoad.getValue(),CanAlarmTypes.RoolRightRoad.getValue()};
                    List<IndexModel> extras3 = this.unSafeMapper.GetCanExtras(codes, keyarr,start,end);
                    List<IndexModel> arr3 = extras3.stream().filter(s -> !StringHelper.isNotEmpty(s.getExtras())).collect(Collectors.toList());
                    arr3.forEach(x ->{
                        x.setSpeed(Double.parseDouble(x.getExtras().split("|")[0]));
                    });
                    int L8 = (int)arr.stream().filter(s -> s.getSpeed() >= 80).count();
                    int L7 = (int)arr.stream().filter(s -> s.getSpeed() >= 55 && s.getSpeed() < 80).count();
                    List<IndexModel> extras4 = this.unSafeMapper.GetCanExtras(codes,new int[]{CanAlarmTypes.LowSpeedBump.getValue()},start,end);
                    List<IndexModel> arr4 = extras4.stream().filter(s -> !StringHelper.isNotEmpty(s.getExtras())).collect(Collectors.toList());
                    arr4.forEach(x ->{
                        x.setSpeed(Double.parseDouble(x.getExtras().split("|")[0]));
                    });
                    int P = arr4.size();
                    List<IndexModel> extras5 = this.unSafeMapper.GetCanExtras(codes,new int[]{CanAlarmTypes.CarDistanceRemind.getValue()},start,end);
                    List<IndexModel> arr5 = extras5.stream().filter(s -> !StringHelper.isNotEmpty(s.getExtras())).collect(Collectors.toList());
                    arr5.forEach(x ->{
                        x.setSpeed(Double.parseDouble(x.getExtras().split("|")[0]));
                    });
                    int H8 = (int)arr.stream().filter(s -> s.getSpeed() >= 80).count();
                    int H7 = (int)arr.stream().filter(s -> s.getSpeed() < 80).count();
                    int T = this.unSafeMapper.GetUnSafeBehaviorId(codes,start,end);
                    double result = (F8 * 1.2 + F7) * 1.2 + F6 + (L8 * 1.2 + L7) * 1 + P * 1.5 + (H8 * 1.2 + H7) * 1 + T * 1;
                    this.unSafeMapper.InsertUnSafeIndexInfo(item.getId(),F8,F7,F6,L8,L7,P,H8,H7,T,result,end);
                }
            }
        }
    }
}
