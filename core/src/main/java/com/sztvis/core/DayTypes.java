package com.sztvis.core;


/**
 * @author longweiqian
 * @company tvis
 * @date 2018/3/13 上午9:30
 */
public class DayTypes {
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public static DayTypes getDayByType(int type){
        DayTypes dayTypes = new DayTypes();
        switch (type){
            case 1://昨天
                dayTypes.setEndTime(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD));
                dayTypes.setStartTime(DateUtil.addDay(dayTypes.getEndTime(),-1));
                break;
            case 2://近7天
                dayTypes.setEndTime(DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),1));
                dayTypes.setStartTime(DateUtil.addDay(dayTypes.getEndTime(),-7));
                break;
            case 3://本月
                dayTypes.setEndTime(DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),1));
                dayTypes.setStartTime(DateUtil.getCurrentTime(DateStyle.YYYY_MM));
                break;
            case 4://上月
                dayTypes.setEndTime(DateUtil.getCurrentTime(DateStyle.YYYY_MM));
                dayTypes.setStartTime(DateUtil.addMonth(dayTypes.getEndTime(),-1));
                break;
            case 5://今年
                dayTypes.setEndTime(DateUtil.addDay(DateUtil.getCurrentTime(DateStyle.YYYY_MM_DD),1));
                dayTypes.setStartTime(DateUtil.getCurrentTime(DateStyle.YYYY)+"-01-01");
                break;
            case 6://去年
                dayTypes.setEndTime(DateUtil.addYear(DateUtil.getCurrentTime(DateStyle.YYYY)+"-01-01",0));
                dayTypes.setStartTime(DateUtil.addYear(dayTypes.getEndTime(),-1));
                break;
            default:
                break;
        }
        return dayTypes;
    }

}
