package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;
import com.sztvis.core.DayTypes;
import com.sztvis.core.helper.StringHelper;
import com.sztvis.domain.HomealramViewModel;
import com.sztvis.domain.domain.TramBasicInfo;
import com.sztvis.domain.domain.TramMemberInfo;
import com.sztvis.domain.dto.*;
import com.sztvis.domain.dto.api.AppAlarmChartModel;
import com.sztvis.domain.dto.api.app.AppAlarmViewModel;
import com.sztvis.dubbo.*;
import com.sztvis.dubbo.prodiver.mapper.AlarmMapper;
import com.sztvis.dubbo.prodiver.mapper.BasicMapper;
import com.sztvis.dubbo.prodiver.mapper.CanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/23 下午3:40
 */
@Service(version = "1.0.0")
public class AlarmService implements IAlarmService {
    @Autowired
    private AlarmMapper alarmMapper;

    @Reference(version = "1.0.0")
    private IDepartmentService iDepartmentService;

    @Reference(version = "1.0.0")
    private IDeviceService iDeviceService;

    @Reference(version = "1.0.0")
    private IBasicService iBasicService;

    @Autowired
    private BasicMapper basicMapper;

    @Reference(version = "1.0.0")
    private IMemberService iMemberService;

    @Autowired
    private CanMapper canMapper;
    @Override
    public List<AlarmViewModel> getAlarmTableList(long userId, long departmentId, long lineId, long type1, long type2, String date1, String date2, String keywords, int offset, int limit) {
        List<Long> departmens = this.iDepartmentService.GetDepartmentIdsByUserId(userId);
        return this.alarmMapper.getAlarmTableList(departmens,departmentId,lineId,type1,type2,date1,date2,keywords,offset,limit);
    }

    @Override
    public int getAlarmTableListCount(long userId, long departmentId, long lineId, long type1, long type2, String date1, String date2, String keywords) {
        List<Long> departmens = this.iDepartmentService.GetDepartmentIdsByUserId(userId);
        return this.alarmMapper.getAlarmTableListCount(departmens,departmentId,lineId,type1,type2,date1,date2,keywords);
    }

    @Override
    public List<AlarmViewModel> getMapAlarmTableList(String devices, String starttime,int page,int limit) {
        return this.alarmMapper.getMapAlarmTableList(devices,starttime,page,limit);
    }

    @Override
    public int getMapAlarmTableCount(String devices,String starttime){
        return this.alarmMapper.getMapAlarmTableCount(devices,starttime);
    }

    @Override
    public AlarmViewModel getAlarmViewModel(long id) {
        return this.alarmMapper.getAlarmViewModel(id);
    }

    @Override
    public List<HomeAlarmViewModel> getTop6HomePageAlarms(long userId) {
        List<Long> devices = this.iDeviceService.getDeviceIdsByUserId(userId);
        return this.alarmMapper.getTop6Alarms(devices);
    }
    @Override
    public int getAlarmTrendsCounts(long userId, String startTime, String endTime, int alarmType) {
        List<Long> devices = this.iDeviceService.getDeviceIdsByUserId(userId);
        return this.alarmMapper.getAlarmTrendsCounts(devices,startTime,endTime,alarmType);
    }

    @Override
    public List<AppAlarmViewModel> GetList(long userId, int dayType, long typeId, int alarmType, String code, long lineId, int page, int limit) {
        List<Long> departments = this.iDepartmentService.GetDepartmentIdsByUserId(userId);
        List<AppAlarmViewModel> list=this.alarmMapper.getAppAlarmList(departments,dayType,lineId,alarmType,code,page,limit);
        return list;
    }

    @Override
    public int getAppAlarmListCount(long userId, int dayType, long typeId, int alarmType, String code, long lineId) {
        List<Long> departments = this.iDepartmentService.GetDepartmentIdsByUserId(userId);
        return this.alarmMapper.getAppAlarmCount(departments,dayType,lineId,alarmType,code);
    }


    @Override
    public CanAlarmInfo GetCanAlarmInfo(int Id){
       return this.alarmMapper.GetCanAlarmInfo(Id);
    }

    @Override
    public BicycleViewModel GetBicycleUnSafeInfo(int dayType, long deviceId){
        String basic="select Id from TramBasicInfo where Fixe=1 and Type=1";
        BicycleViewModel model=new BicycleViewModel();
        model.AxisValues=new ArrayList<String>();
        DayTypes dayTypes=DayTypes.getDayByType(dayType);
        int day= DateUtil.getIntervalDays(dayTypes.getEndTime(),dayTypes.getStartTime());
        if(dayType==5||dayType==6) {
            try {
                day=DateUtil.monthsBetween(dayTypes.getEndTime(),dayTypes.getStartTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        for (int j=0;j<day;j++)
        {
            String date2=(DateUtil.addDay(dayTypes.getStartTime(),j));
            String dt=DateUtil.StringToString(date2.toString(),"MM-DD");
            if(dayType==5||dayType==6)
            {
                date2=(DateUtil.addMonth(dayTypes.getStartTime(),j));
                dt=DateUtil.StringToString(date2.toString(),"MM");
            }
            model.AxisValues.add(dt);
        }
        model.Items=new ArrayList<>();
        List<TramBasicInfo> types=this.basicMapper.Types();
        for (TramBasicInfo r:types)
        {
            BicycleViewModel.BicycleUnSafeStatisModel model2 = new BicycleViewModel.BicycleUnSafeStatisModel();
            model2.setAxisName(r.getAlarmName());
            model2.setAxisyValues(new ArrayList<>());
            Long AxisId=r.getId();
            for (int j = 0; j < day; j++)
            {
                String date2 = (DateUtil.addDay(dayTypes.getStartTime(),j));
                if (dayType == 5 || dayType == 6)
                    date2 = (DateUtil.addMonth(dayTypes.getStartTime(),j));
                int Count=this.alarmMapper.CountId(deviceId,AxisId,dayTypes.getStartTime(), date2);
                model2.AxisyValues.add(Double.valueOf(Count));
            }
        }
        return model;
    }

    @Override
    public AppAlarmChartModel GetAppAlarmCharts(long userId, long lineId, int type)
    {
        AppAlarmChartModel model= new AppAlarmChartModel();
        TramMemberInfo info=this.iMemberService.getMemberInfo(userId);
        CurrentUserInfo userInfo=new CurrentUserInfo();
        userInfo.setUserName(info.getUsername());
        userInfo.setDepartmentId(info.getOwnershipid());
        List<Long> deviceIds=this.iDeviceService.GetDeviceIdsByDepartmentId(userInfo);
        List<AppAlarmChartModel.xVal> arr=this.alarmMapper.xValCharsSQL(info.getRolelv(),1, Long.valueOf("0"));
        String startTime="";
        String endTime=DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),1);
        if (type==1)
            startTime=DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD);
        if (type==2)
            startTime=DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),-1);
        if (type==3)
            startTime=DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),-6);
        int day=DateUtil.getIntervalDays(startTime,endTime);
        List<String> xVals=new ArrayList<>();
        for (int j1=0;j1<day;j1++)
        {
            xVals.add(DateUtil.addDay(startTime,j1).toString());
        }
        model.setxVals(xVals);
        List<AppAlarmChartModel.yVal> list=new ArrayList<>();
        List<AppAlarmChartModel.TypeModel3> list2=new ArrayList<>();
        for (int i=0;i<arr.size();i++)
        {
            AppAlarmChartModel.yVal yval=new AppAlarmChartModel.yVal();
            List<Integer> list1=new ArrayList<>();
            for (int j=0;j<day;j++)
            {
                String start=DateUtil.addDay(startTime,j);
                String end=DateUtil.addDay(startTime,j+1);
                int ssa=this.alarmMapper.GetAppAlarmChartsSQL1(arr.get(i).getId(),2,start,lineId,end,deviceIds);
                list1.add(ssa);
            }
            yval.setVal(list1);
            yval.setTime(arr.get(i).getName());
            yval.setId(arr.get(i).getId());
            list.add(yval);
            AppAlarmChartModel.TypeModel3 model3=new AppAlarmChartModel.TypeModel3();
            List<AppAlarmChartModel.TypeModel4> list4=this.alarmMapper.TypeModel4SQL(info.getRolelv(),2,arr.get(i).getId());
            List<AppAlarmChartModel.TypeModel4> listType4=new ArrayList<>();
            for (AppAlarmChartModel.TypeModel4 r:list4)
            {
                AppAlarmChartModel.TypeModel4 model4=new AppAlarmChartModel.TypeModel4();
                model4.setId(r.getId());
                model4.setName(r.getName());
                model4.setCount(this.alarmMapper.GetAppAlarmChartsSQL1(arr.get(i).getId(),1,startTime,lineId,endTime,deviceIds));
                listType4.add(model4);
            }
            model3.setTitle(arr.get(i).getName());
            model3.setList(listType4);
            list2.add(model3);
        }
        model.yVals=list;
        model.setModes(list2);
        return model;
    }

    @Override
    public HomealramViewModel.ViewModel GetTop10Alarms(long userId)
    {
        String date1="'"+DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD_00_00_00)+"'",
                date2="'"+DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD_23_59_59)+"'";
       String Devices = StringHelper.getLists(this.iBasicService.getDeviceIdsByRoleLv(userId).toString());
       String AlarmKeys = StringHelper.getLists(this.iBasicService.GetAlarmKeysByUserId(userId).toString());
       HomealramViewModel.ViewModel viewModel=new HomealramViewModel.ViewModel();
        List<HomealramViewModel> list=this.alarmMapper.GetTop10Alarms(date1,date2,Devices,AlarmKeys);
       viewModel.setView(list);
       viewModel.setCount(this.canMapper.GetTotal(date1,date2,Devices,AlarmKeys));
       return viewModel;
    }

    @Override
    public WelcomeTrendModel getAlarmChartList(long lineId,int type,String type1,String date2,String date3,String code,long departmentId){
        int days = 7;
        if (StringHelper.isNotEmpty(date2)&&StringHelper.isNotEmpty(date3)){
            days = DateUtil.getIntervalDays(date3,date2);
        }
        else if (StringHelper.isEmpty(date2) || StringHelper.isEmpty(date3)){
            date3 = DateUtil.getCurrentTime();
            date2 = DateUtil.addDay(date3,-6);
        }
        List<String> time = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = null;
        List<String> title = new ArrayList<>();
        if (type!=0){
            if (type1.equals("0")) {
                title.add(canMapper.GetAlarmChartList2(type));
            }
            else
                title.add(canMapper.GetAlarmChartList2(Integer.valueOf(type1)));
        }
        else
        {
            title.add("报警总数");
        }
        for (String i : title){
            list1 = new ArrayList<>();
            for(int i4 = days - 1;i4 >= 0  ; i4--){
                int r = canMapper.GetAlarmChartList(code,lineId,type,type1,DateUtil.StringToString(DateUtil.addDay(date3,-i4),DateStyle.YYYY_MM_DD_00_00_00),DateUtil.StringToString(DateUtil.addDay(date3,-i4),DateStyle.YYYY_MM_DD_23_59_59),departmentId);
                list1.add(r);
            }
            list.add(list1);
        }
        for (int t = days - 1;t >= 0 ;t--){
            time.add(DateUtil.getDay(DateUtil.addDay(date3,-t))+"日");
        }
        WelcomeTrendModel model = new WelcomeTrendModel();
        model.setUnsafes(list);
        model.setXalias(time);
        model.setUnsafeXalias(title);
        return  model;
    }

    @Override
    public void updateAlarmImage(String images, String deviceCode, String updateTime) {
        this.alarmMapper.updateAlarmImages(images,deviceCode,updateTime);
    }

    @Override
    public int getTodayAlarmCount(long userId) {
        List<Long> devices = this.iBasicService.getDeviceIdsByRoleLv(userId);
        return this.alarmMapper.getTodayAlarmCount(devices);
    }
}
