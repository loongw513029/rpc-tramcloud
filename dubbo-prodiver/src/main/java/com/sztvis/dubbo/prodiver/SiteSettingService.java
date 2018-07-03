package com.sztvis.dubbo.prodiver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.sztvis.core.DateStyle;
import com.sztvis.core.DateUtil;
import com.sztvis.domain.dto.SelectViewModel;
import com.sztvis.domain.dto.SiteSettingViewModel;
import com.sztvis.domain.dto.SiteSettingsInfo;
import com.sztvis.domain.dto.service.ChartViewModel;
import com.sztvis.dubbo.IBasicService;
import com.sztvis.dubbo.ILineService;
import com.sztvis.dubbo.ISiteSettingService;
import com.sztvis.dubbo.prodiver.mapper.SiteSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service(version = "1.0.0")
public class SiteSettingService implements ISiteSettingService {

    @Reference(version = "1.0.0")
    private IBasicService iBasicService;

    @Reference(version = "1.0.0")
    private ILineService iLineService;

    @Autowired
    private TimehelpService timehelpService;

    @Autowired
    private SiteSettingMapper siteSettingMapper;

    @Override
    public ChartViewModel GetAppCharts(long userId, long lineId) {
            Date date = new Date();
            String start = DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD);
            String end = DateUtil.addDay(start,1);
            Calendar calendar = Calendar.getInstance();
            ChartViewModel model = new ChartViewModel();
            List<Long> Device = this.iBasicService.getDeviceIdsByRoleLv(userId);
            List<SelectViewModel> list = this.iLineService.GetDropDownLine(userId);
            List<Long> LineArr=new  ArrayList<>();
            for (SelectViewModel r : list) {
                Long Id = Long.valueOf((r.getId()));
                LineArr.add(Id);
            }
            model.setTotalAlarmCount(this.siteSettingMapper.GetAppCharts(5, Device, lineId, start, end));
            model.setTotalDeviceCount(this.siteSettingMapper.GetAppCharts(1, LineArr, lineId, null, null));
            model.setTotalLineCount(this.siteSettingMapper.GetAppCharts(3, LineArr, null, null, null));
            model.setTotalUnsafeCount(this.siteSettingMapper.GetAppCharts(4, Device, lineId, start, end));
            model.setOnLineDeviceCount(this.siteSettingMapper.GetAppCharts(2, LineArr, lineId, null, null));
            ChartViewModel.ChartListViewModel viewModel = new ChartViewModel.ChartListViewModel();
            List<ChartViewModel.ChartListViewModel> listview = new ArrayList<>();
            List<ChartViewModel.ChartData> listdate = new ArrayList<>();
            viewModel.setChartName("不安全行为趋势图");
            for (int i = 6; i >= 0; i--) {
                ChartViewModel.ChartData data = new ChartViewModel.ChartData();
                String date1 = timehelpService.getSomeDay(date, -i, "yyyy-MM-dd");
                String date2 = timehelpService.getSomeDay(date, -i + 1, "yyyy-MM-dd");
                String name = timehelpService.getSomeDay(date, -i, "MM-dd");
                int count = this.siteSettingMapper.GetAppCharts(4, LineArr, lineId, date1, date2);
                data.setAxisName(name);
                data.setAxisValue(count);
                listdate.add(data);
            }
            viewModel.setData(listdate);
            listview.add(viewModel);
            ChartViewModel.ChartListViewModel viewMode2 = new ChartViewModel.ChartListViewModel();
            List<ChartViewModel.ChartData> listdate2 = new ArrayList<>();
            viewMode2.setChartName("车辆报警趋势图");
            for (int i = 6; i >= 0; i--) {
                ChartViewModel.ChartData data = new ChartViewModel.ChartData();
                String date1 = timehelpService.getSomeDay(date, -i, "yyyy-MM-dd");
                String date2 = timehelpService.getSomeDay(date, -i + 1, "yyyy-MM-dd");
                String name = timehelpService.getSomeDay(date, -i, "MM-dd");
                int count = this.siteSettingMapper.GetAppCharts(5, LineArr, lineId, date1, date2);
                data.setAxisName(name);
                data.setAxisValue(count);
                listdate2.add(data);
            }
            viewMode2.setData(listdate2);
            listview.add(viewMode2);
            model.setChartList(listview);
            return model;
    }

    @Override
    public SiteSettingsInfo GetSiteSettings() throws Exception {
        SiteSettingsInfo model = new SiteSettingsInfo();
        Class cls = (Class) model.getClass();
        List<SiteSettingViewModel> list = this.siteSettingMapper.GetSiteSettings();
        for (SiteSettingViewModel site : list) {
            Field fs = cls.getDeclaredField(site.getKey());
            fs.setAccessible(true);
            String type = fs.getType().toString().toLowerCase();
            switch (type) {
                case "long":
                    fs.set(model, Long.valueOf(site.getValue()));
                    break;
                case "int":
                    fs.set(model, Integer.valueOf(site.getValue()));
                    break;
                case "double":
                    fs.set(model, Double.valueOf(site.getValue()));
                    break;
                case "class java.lang.string":
                    fs.set(model, site.getValue());
                    break;
            }
        }
        return model;
    }

    @Override
    public void SaveSetting(String key, Object value){
        if (value == null){
            throw new NullPointerException("值不能为null");
        }
//        Field[] item = model.getClass().getFields();
//        if(Arrays.stream(item).allMatch(x->x.getName()==key)){
//            throw new NoSuchFieldError("未找到"+ key +"对应的配置项");
//        }
        Map<String,Object> set = this.siteSettingMapper.GetGetSiteSettingsKey(key);
        if (set == null)
            this.siteSettingMapper.InsertSaveSetting(key,value);
        else
            this.siteSettingMapper.updateSaveSetting(key,value);
    }

    @Override
    public SiteSettingsInfo GetSave() {
        List<String> name = this.siteSettingMapper.GetSavekey();
        List<Object> values = this.siteSettingMapper.GetSavevalue();
        SiteSettingsInfo model = new SiteSettingsInfo();
        Field[] fields = model.getClass().getDeclaredFields();
        List<String> modelName = new ArrayList<>();
        List<String> modelType = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            // 获取属性的名字
            modelName.add(fields[i].getName());
            // 获取属性类型
            modelType.add(fields[i].getGenericType().toString());
        }
        for (String key : name){
            String type = modelType.get(modelName.indexOf(key));
            if (type.equals("class java.lang.String")) {
                try {
                    Method m = model.getClass().getMethod("set"+key,String.class);
                    String value = values.get(name.indexOf(key)).toString();
                    m.invoke(model,value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (type.equals("int")){
                try {
                    Method m = model.getClass().getMethod("set"+key,int.class);
                    int value = Integer.parseInt(values.get(name.indexOf(key)).toString());
                    m.invoke(model,value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (type.equals("double")){
                try {
                    Method m = model.getClass().getMethod("set"+key,double.class);
                    double value = Double.valueOf(values.get(name.indexOf(key)).toString());
                    m.invoke(model,value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return model;
    }
}
