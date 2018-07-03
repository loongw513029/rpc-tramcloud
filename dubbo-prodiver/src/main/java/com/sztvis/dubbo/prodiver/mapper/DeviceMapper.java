package com.sztvis.dubbo.prodiver.mapper;

import com.sztvis.domain.TramDeviceOnLineTimeLongInfo;
import com.sztvis.domain.domain.*;
import com.sztvis.domain.dto.*;
import com.sztvis.domain.dto.api.DeviceFilterSearchResult;
import com.sztvis.dubbo.prodiver.mapper.provider.DeviceSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/28 下午5:40
 */
@Repository
public interface DeviceMapper {

    @Select("select id from TramDeviceInfo")
    List<Long> getTramDeviceId();

    @Select("select Id,deviceCode from TramDeviceInfo")
    List<TramDeviceInfo> getTramDeviceCodeId();

    @Select("select Id from TramLineInfo where DeparentId in (select Id from TramDepartmentInfo where Id=#{parentId})")
    List<Long> getLineIdsByDepartmentId(Long parentId);

    @Select("select Id from TramDeviceInfo where lineId in (#{lineIds})")
    List<Long> getDeviceByLineIds(String lineIds);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getDeviceCodesByLineIds")
    List<String> getDeviceCodesByLineIds(@Param("lineIds") List<Long> lineIds);

    @Select("select DeviceCode from TramDeviceInfo where Id in #{Id}")
    List<String> getDeviceCodesBIds(List<Long> Id);

    @Select("select deviceCode from TramDeviceInfo")
    List<String> getDeviceCodes();

    @Select("select DeviceCode from TramDeviceInfo where DepartmentId in(select Id from TramDepartmentInfo where Id=#{departmentId} or ParentId=#{departmentId})")
    List<String> getDeviceCodesByDepartmentId(Long departmentId);

    @Select("select Id from TramDeviceInfo where DepartmentId in(select Id from TramDepartmentInfo where Id=#{departmentId} or ParentId=#{departmentId})")
    List<Long> getDeviceIdByDepartmentId(Long departmentId);

    @Select("select * from TramDeviceInfo where lineId=#{lineId}")
    List<TramDeviceInfo> getDevicesByLineId(long lineId);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getDeviceCountSQL")
    Integer getDeviceCount(@Param("state") int state, @Param("departments") List<Long> departments);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getOnlineCountSQL")
    int getRealTimeOnlineCount(@Param("departments") List<Long> departments);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getOnlinePrecentSQL")
    Integer getOnlinePrecent(@Param("departments") List<Long> departments, @Param("startTime") String startTime);

    @SelectProvider(type=DeviceSqlProvider.class,method = "getUnSafeCountSQL")
    Integer getUnSafeCountByDepartmentIds(@Param("departments") List<Long> departments, @Param("startTime") String startTime);

    @Select("select * from TramDeviceInfo where id =#{deviceId}")
    TramDeviceInfo getDeviceInfoById(long deviceId);

    @Select("select id from TramDeviceInfo where devicecode=#{deviceCode}")
    long getDeviceIdByCode(String deviceCode);

    @Select("select * from TramDeviceInfo where deviceCode=#{deviceCode}")
    TramDeviceInfo getDeviceInfoByCode(String deviceCode);

    @Update("update TramDeviceInfo set deviceStatus=#{value} where deviceCode=#{deviceCode}")
    void udpateDeviceState(@Param("deviceCode") String deviceCode, @Param("value") int value);

    @Update("update TramDeviceInfo set LastOnlineTime=#{time} where devicecode=#{code}")
    void updateLastOnlineTime(@Param("time") String time, @Param("code") String code);

    @Select("select * from TramDeviceOnLineTimeLongInfo where DeviceCode=#{code} order by CreateTime desc limit 1")
    TramDeviceOnLineTimeLongInfo getLongInfo(@Param("code") String code);

    @Insert("insert into TramDeviceOnLineTimeLongInfo(DeviceCode,OnLineTime,OffLineTime,TotalTime,CreateTime)values(#{code},#{time1},#{time2},#{total},#{time3})")
    void InsertTramDeviceOnLineTimeLongInfo(@Param("code") String code, @Param("time1") String time1, @Param("time2") String time2, @Param("total") int total, @Param("time3") String time3);

    @Update("update TramDeviceOnLineTimeLongInfo set OffLineTime=#{OffLineTime},TotalTime=#{TotalTime} where Id=#{Id}")
    void updateTramDeviceOnLineTimeLongInfo(@Param("OffLineTime") String OffLineTime, @Param("TotalTime") int TotalTime, @Param("Id") Long Id);

    @Update("update TramDeviceStateInspectRealTimeInfo set #{field}=#{value} where deviceId=#{deviceId}")
    void updateRealTimeInfo(@Param("field") String field, @Param("deviceId") long deviceId, @Param("value") Object value);

    @Insert("insert TramDeviceStateInspectRealTimeInfo(deviceId,#{field})values(#{deviceId},#{value})")
    void insertRealTimeInfo(@Param("field") String field, @Param("deviceId") long deviceId, @Param("value") Object value);

    @Select("select count(Id) from tramdevicestateinspectrealtimeinfo where deviceCode=#{deviceCode}")
    int getRealtimeInspectCount(String deviceCode);

    @Select("select count(Id) from DeviceOnlineRecords where devicecode=#{code} and updatetime=#{time}")
    int getCountOnlineRecords(@Param("code") String code, @Param("time") String time);

    @Insert("insert into DeviceOnlineRecords(DeviceCode,updatetime)values(#{code},#{time})")
    void InsertOnlineRecords(@Param("code") String code, @Param("time") String time);

    /**
     * 修改巡检状态
     * @param deviceCode 设备编码
     * @param field 字段名
     * @param value 字段值
     * @param fieldtype 字段类型 1:字符串，2：Double/Int, 3:boolean
     */
    @UpdateProvider(type = DeviceSqlProvider.class,method = "updateRealtimeInspectSQL")
    void updateRealtimeInspect(@Param("deviceCode") String deviceCode, @Param("field") String field, @Param("value") Object value, @Param("fieldtype") int fieldtype);

    @Insert("insert into tramdevicestateinspectrealtimeinfo(deviceid,videotape,video,harddisk,sdcard,cpuuserate,cputemp,mermoryuserate,disktemp,gpsstate,canstate,internetstate,gpssignelstate,simbalance,gpsinspectstate,caninspectstate,behaviorinspectstate,radarinspectstate,adasinspectstate,timingstate,deviceCode,surplusDiskSize,surplusSdcardSize)values(#{deviceid},#{videotape},#{video},#{harddisk},#{sdcard},#{cpuuserate},#{cputemp},#{mermoryuserate},#{disktemp},#{gpsstate},#{canstate},#{internetstate},#{gpssignelstate},#{simbalance},#{gpsinspectstate},#{caninspectstate},#{behaviorinspectstate},#{radarinspectstate},#{adasinspectstate},#{timingstate},#{deviceCode},#{surplusDiskSize},#{surplusSdcardSize})")
    void insertRealtimeInspect(TramDeviceStateInspectRealtimeInfo info);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getWebListSQL")
    List<DeviceViewModel> getBusList(@Param("departments") List<Long> departments,
                                     @Param("devicetype") int devicetype,
                                     @Param("departmentId") long departmentId,
                                     @Param("lineId") long lineId,
                                     @Param("status") int status,
                                     @Param("keywords") String keywords
    );
    @SelectProvider(type = DeviceSqlProvider.class,method = "getDeviceViewModel")
    DeviceViewModel getDeviceViewModel(@Param("id") long id);

    @Select("select * from tramdevicestateinspectrealtimeinfo where deviceid=#{deviceid}")
    TramDeviceStateInspectRealtimeInfo getDeviceStateInspectRealTimeInfo(long deviceid);

    @Select("select a.id,a.devicecode,a.devicename,a.hostsofttype,a.busid,a.clientip,a.devicemode,a.disksize,a.sdcardsize,a.videosupport,a.videochannel,a.dchannel,a.carriagechannel,a.aerialview,a.aerialchannel,a.barrier,a.can,a.radar,a.supportbehavior,a.supportadas,a.speeduse,b.busnumber,b.busframenumber,b.bustype,a.departmentid,a.lineid,b.driverid from tramdeviceinfo a left join trambusinfo b on a.busid=b.id where a.id=#{id}")
    BusAndDeviceViewModel getBusAndDeviceInfo(long id);

    @Select("select channelname,no,supportptz from TramChannelInfo where deviceid =#{id}")
    List<ChannelViewModel> getChannelViewModelList(long id);

    @Insert("insert into TramDeviceInfo(guid,busid,departmentid,lineid,devicecode,devicename,clientip,ispositive,videosupport,videochannel,dchannel,carriagechannel,devicetypeid,canbustypeid,devicemode,hostsofttype,disksize,sdcardsize,devicestatus,aerialview,aerialchannel,barrier,can,radar,supportbehavior,supportadas,passengerflow,speeduse,createtime,lastonlinetime)values(#{guid},#{busid},#{departmentid},#{lineid},#{devicecode},#{devicename},#{clientip},#{ispositive},#{videosupport},#{videochannel},#{dchannel},#{carriagechannel},#{devicetypeid},#{canbustypeid},#{devicemode},#{hostsofttype},#{disksize},#{sdcardsize},#{devicestatus},#{aerialview},#{aerialchannel},#{barrier},#{can},#{radar},#{supportbehavior},#{supportadas},#{passengerflow},#{speeduse},#{createtime},#{lastonlinetime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertDeviceInfo(TramDeviceInfo deviceInfo);

    @Update("update TramDeviceInfo set busid=#{busid},departmentid=#{departmentid},lineid=#{lineid},devicecode=#{devicecode},devicename=#{devicename},clientip=#{clientip},videosupport=#{videosupport},videochannel=#{videochannel},dchannel=#{dchannel},carriagechannel=#{carriagechannel},devicemode=#{devicemode},hostsofttype=#{hostsofttype},disksize=#{disksize},sdcardsize=#{sdcardsize},aerialview=#{aerialview},aerialchannel=#{aerialchannel},barrier=#{barrier},can=#{can},radar=#{radar},supportbehavior=#{supportbehavior},supportadas=#{supportadas},speeduse=#{speeduse} where id=#{id}")
    void updateDeviceInfo(TramDeviceInfo deviceInfo);

    @Insert("insert into TramBusInfo(guid,busplate,departmentid,lineid,bustype,busmode,busnumber,busframenumber,driverid,busstatus,createtime)values(#{guid},#{busplate},#{departmentid},#{lineid},#{bustype},#{busmode},#{busnumber},#{busframenumber},#{driverid},#{busstatus},#{createtime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertBusInfo(TramBusInfo busInfo);

    @Update("update TramBusInfo set departmentid=#{departmentid},lineid=#{lineid},busnumber=#{busnumber},busframenumber=#{busframenumber},driverid=#{driverid} where id=#{id}")
    void updateBusInfo(TramBusInfo busInfo);

    @Insert("insert into TramChannelInfo(deviceid,no,channelname,supportptz)values(#{deviceid},#{no},#{channelname},#{supportptz})")
    void insertChannelInfo(TramChannelInfo channelInfo);

    @Delete("delete from TramDeviceInfo where id in(#{ids})")
    void removeDeviceInfo(String ids);

    @Delete("delete from TramBusInfo where id in (#{ids})")
    void removeBusInfo(String ids);

    @Delete("delete from TramChannelInfo where deviceid=#{deviceid}")
    void removeChannelInfo(long deviceid);

    @Delete("delete from TramChannelInfo where deviceid in(#{deviceIds})")
    void removeChannels(String deviceIds);

    @Select("select busid from TramDeviceInfo where id in(#{deviceIds})")
    List<Long> getBusIds(String deviceIds);

    //@Select("select a.id,a.devicecode,b.departmentname,c.linename,e.busnumber from tramdeviceinfo a left join trambusinfo e on a.busid=e.id left join tramdepartmentinfo b on a.departmentid=b.id left join tramlineinfo c on a.lineid=c.id where a.id in(#{devices})")
    @SelectProvider(type = DeviceSqlProvider.class,method = "getMapDeviceListSQL")
    List<MapDeviceViewModel> getMapDeviceList(@Param("devices") String devices);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getDeviceInspectSQL")
    List<DeviceInspectViewModel> getDeviceInspectList(@Param("departments") List<Long> departmens, @Param("departmentid") long departmentid, @Param("lineid") long lineid, @Param("type") int type, @Param("keywords") String keywords);

    @Select("select * from TramDeviceInfo")
    List<TramDeviceInfo> getAllDevices();

    @Insert("insert into CanHistoryEveryDayInfo(deviceid,updatetime,totalmileage,gasonlieavg,electricavg,gasavg,totalfaultnumber,totalcarfaultnumber,faultthreelv,faultsecondlv,faultonelv,unsafenumber,unsafedriver,speedingtotal,runtimelong)values(#{deviceid},#{updatetime},#{totalmileage},#{gasonlieavg},#{electricavg},#{gasavg},#{totalfaultnumber},#{totalcarfaultnumber},#{faultthreelv},#{faultsecondlv},#{faultonelv},#{unsafenumber},#{unsafedriver},#{speedingtotal},#{runtimelong})")
    void insertCanHistoryEveryDayData(CanHistoryEveryDayInfo info);

    @Select("select count(id) from tramunsafebehaviorinfo where deviceId=#{deviceId} and ApplyTime>=#{time1} and ApplyTime<=#{time2}")
    long getUnsafeCountByDeviceIdEveryDay(@Param("deviceId") long deviceId, @Param("time1") String time1, @Param("time2") String time2);

    @Update("update TramDeviceInfo set deviceStatus=#{status} where devicecode=#{deviceCode}")
    void updateDeviceStatus(@Param("deviceCode") String deviceCode, @Param("status") int status);

    @Select("select * from TramBusInfo where id=#{busId}")
    TramBusInfo getBusInfo(long busId);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getDeviceIdByDepartmentIds")
    List<Long> getDeviceIdByDepartmens(@Param("departments") List<Long> departments);

    @Select("select id from TramDeviceInfo")
    List<Long> getAllDeviceIds();

    @SelectProvider(type = DeviceSqlProvider.class,method = "getDevices")
    List<TramDeviceInfo> getDevices(@Param("deviceIds") List<Long> deviceIds, @Param("lineId") Long lineId);

    @SelectProvider(type = DeviceSqlProvider.class,method = "GetDriverInfoSQL")
    TramDeviceInfo GetDriverInfo(@Param("Id") Long Id, @Param("code") String code);

    @Select("select a.* from TramDriverInfo a left join TramBusInfo b on a.Id = b.DriverId left join TramDeviceInfo c on b.Id = c.BusId where c.DeviceCode = #{code}")
    TramDeviceInfo GetDriverInfos(@Param("code") String Code);

    @SelectProvider(type = DeviceSqlProvider.class,method = "GetAppDeviceFilterSearchSQL")
    DeviceFilterSearchResult GetAppDeviceFilterSearch(@Param("Code") String code);

    @SelectProvider(type = DeviceSqlProvider.class,method = "GetDeviceIdsByDepartmentIdSQL")
    List<Long> GetDeviceIdsByDepartmentId(@Param("user") CurrentUserInfo user);

    @Select("select a.Id as DeviceId,a.DeviceCode,a.BusId,a.LineId,b.BusNumber,b.BusType,a.DeviceStatus as Status,c.LineName,d.DriverName from TramDeviceInfo a left join TramBusInfo b on a.BusId=b.Id left join TramLineInfo c on a.LineId = c.Id left join TramDriverInfo d on b.DriverId = d.Id where a.Id=#{deviceId}")
    AppBusViewModel GetAppBusModelsql1(@Param("deviceId") Long deviceId);

    @Select("select SUM(TotalMileage) from CanHistoryEveryDayInfo where deviceId=#{deviceId} and UpdateTime=#{time}")
    Double GetAppBusModelsql2(@Param("deviceId") Long deviceId, @Param("time") String time);

    @Select("select * from TramChannelInfo where deviceId=#{deviceId}")
    List<TramChannelInfo> GetChannelsByDeviceId(long deviceId);

    @Select("select count(Id) from TramDeviceHealthInfo where DeviceCode=#{code} and UpdateTime>=#{date1} and UpdateTime<=#{date2}")
    int GetCountByDateTime(@Param("code") String code, @Param("date1") String date1, @Param("date2") String date2);

    @SelectProvider(type = DeviceSqlProvider.class,method = "AutoInspectDeviceADASSQL")
    int AutoInspectDeviceADAS(@Param("SqlType") String SqlType, @Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end);

    int AutoInspectDeviceADAS(@Param("SqlType") String SqlType, @Param("adasArr") long[] adasArr, @Param("deviceId") long deviceId, @Param("start") String start, @Param("end") String end);
    TramDeviceStatusInfo AutoInspectDeviceADAS(@Param("SqlType") String SqlType, @Param("deviceId") long deviceId, @Param("type") String type);

    List<TramDeviceInfo> AutoInspectDeviceADAS(@Param("SqlType") String SqlType);

    @Insert("insert into TramDeviceStatusInfo values(#{Guid},#{DeviceId},#{DeviceCode},#{UpdateTime},#{Type},#{Value1},#{Value2},#{Now})")
    void InsertDeviceStatus(TramDeviceStatusInfo info, @Param("Now") String now);

    @Select("select count(Id) from TramDeviceStateInspectRealTimeInfo where deviceId=#{deviceId}")
    int DeviceStateInspectRealTime(long deviceId);

    @Insert("insert TramDeviceStateInspectRealTimeInfo(deviceId,#{field})values(#{deviceId},#{value})")
    void InsertDeviceStateInspectRealTime(@Param("field") String field, @Param("deviceId") long deviceId, @Param("value") Object value);

    @Update("update TramDeviceStateInspectRealTimeInfo set #{field}=#{value} where deviceId=#{deviceId}")
    void UpdateDeviceStateInspectRealTime(@Param("field") String field, @Param("deviceId") long deviceId, @Param("value") Object value);

    @Select("select a.deviceCode from TramDeviceInfo a left join TramBusInfo b on a.BusId=b.Id where b.DriverId =#{driverId}")
    List<String> GetDeviceCodeByDriverId(long driverId);

    @Insert("insert into PayTerminalRecords(deviceId,deviceCode,updateTime,payCardNo,payTime,location,siteName,passengerImage)values(#{deviceId},#{deviceCode},#{updateTime},#{payCardNo},#{payTime},#{location},#{siteName},#{passengerImage})")
    void insertPayTerminalRecords(PayTerminalRecords payTerminalRecords);

    @Update("update TramDeviceInfo set LastOnlineTime=#{lastTime} where id=#{deviceId}")
    void updateDeviceLastTime(@Param("deviceId") long deviceId, @Param("lastTime") String lastTime);

    @SelectProvider(type = DeviceSqlProvider.class,method = "getPayRecordsSql")
    List<PayTerminalRecords> getPayRecords(@Param("cardno") String cardno, @Param("date1") String date1, @Param("date2") String date2, @Param("sitename") String sitename);

    @Insert("insert into Deviceonlinerecords(devicecode,updatetime)values(#{devicecode},#{updatetime})")
    void insertDeviceOnlineRecord(Deviceonlinerecords record);

    @Select("select count(Id) from Deviceonlinerecords where devicecode=#{devicecode} and updatetime=#{updatetime}")
    long getDeviceOnlineRecordCount(@Param("devicecode") String devicecode, @Param("updatetime") String updatetime);

    @Update("update PayTerminalRecords set passengerImage=#{image} where deviceCode=#{deviceCode} and updateTime=#{updateTime}")
    void updatePayTerminalImage(@Param("image") String image, @Param("deviceCode") String deviceCode, @Param("updateTime") String updateTime);

    @Select("select count(Id) from TramAlarmInfo where devicecode=#{devicecode} and updatetime>=#{startTime} and updatetime<=#{endTime} and parentAlarmType=#{parentId}")
    int getAlarmCount(@Param("parentId") long parentId, @Param("devicecode") String devicecode, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
