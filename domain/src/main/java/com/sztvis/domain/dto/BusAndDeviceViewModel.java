package com.sztvis.domain.dto;


import com.sztvis.domain.domain.TramBusInfo;
import com.sztvis.domain.domain.TramDeviceInfo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/22 下午4:43
 */
public class BusAndDeviceViewModel implements Serializable{
    private long id;
    private String busnumber;
    private String busframenumber;
    private int bustype;
    private long departmentid;
    private long lineid;
    private long driverid;
    private String devicecode;
    private String devicename;
    private String clientip;
    private String devicemode;
    private String disksize;
    private String sdcardsize;
    private int hostsofttype;
    private boolean videosupport;
    private int videochannel = 0;
    private int dchannel;
    private int carriagechannel;
    private boolean aerialview;
    private int aerialchannel;
    private boolean barrier;
    private boolean can;
    private boolean radar;
    private boolean supportbehavior;
    private boolean supportadas;
    private boolean passengerflow;
    private int speeduse;
    private long busid;
    private String channellist;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusnumber() {
        return busnumber;
    }

    public void setBusnumber(String busnumber) {
        this.busnumber = busnumber;
    }

    public String getBusframenumber() {
        return busframenumber;
    }

    public void setBusframenumber(String busframenumber) {
        this.busframenumber = busframenumber;
    }

    public int getBustype() {
        return bustype;
    }

    public void setBustype(int bustype) {
        this.bustype = bustype;
    }

    public long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(long departmentid) {
        this.departmentid = departmentid;
    }

    public long getLineid() {
        return lineid;
    }

    public void setLineid(long lineid) {
        this.lineid = lineid;
    }

    public long getDriverid() {
        return driverid;
    }

    public void setDriverid(long driverid) {
        this.driverid = driverid;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getClientip() {
        return clientip;
    }

    public void setClientip(String clientip) {
        this.clientip = clientip;
    }

    public String getDevicemode() {
        return devicemode;
    }

    public void setDevicemode(String devicemode) {
        this.devicemode = devicemode;
    }

    public String getDisksize() {
        return disksize;
    }

    public void setDisksize(String disksize) {
        this.disksize = disksize;
    }

    public String getSdcardsize() {
        return sdcardsize;
    }

    public void setSdcardsize(String sdcardsize) {
        this.sdcardsize = sdcardsize;
    }

    public int getHostsofttype() {
        return hostsofttype;
    }

    public void setHostsofttype(int hostsofttype) {
        this.hostsofttype = hostsofttype;
    }

    public boolean isVideosupport() {
        return videosupport;
    }

    public void setVideosupport(boolean videosupport) {
        this.videosupport = videosupport;
    }

    public int getVideochannel() {
        return videochannel;
    }

    public void setVideochannel(int videochannel) {
        this.videochannel = videochannel;
    }

    public int getDchannel() {
        return dchannel;
    }

    public void setDchannel(int dchannel) {
        this.dchannel = dchannel;
    }

    public int getCarriagechannel() {
        return carriagechannel;
    }

    public void setCarriagechannel(int carriagechannel) {
        this.carriagechannel = carriagechannel;
    }

    public boolean isAerialview() {
        return aerialview;
    }

    public void setAerialview(boolean aerialview) {
        this.aerialview = aerialview;
    }

    public int getAerialchannel() {
        return aerialchannel;
    }

    public void setAerialchannel(int aerialchannel) {
        this.aerialchannel = aerialchannel;
    }

    public boolean isBarrier() {
        return barrier;
    }

    public void setBarrier(boolean barrier) {
        this.barrier = barrier;
    }

    public boolean isCan() {
        return can;
    }

    public void setCan(boolean can) {
        this.can = can;
    }

    public boolean isRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }

    public boolean isSupportbehavior() {
        return supportbehavior;
    }

    public void setSupportbehavior(boolean supportbehavior) {
        this.supportbehavior = supportbehavior;
    }

    public boolean isSupportadas() {
        return supportadas;
    }

    public void setSupportadas(boolean supportadas) {
        this.supportadas = supportadas;
    }

    public int getSpeeduse() {
        return speeduse;
    }

    public void setSpeeduse(int speeduse) {
        this.speeduse = speeduse;
    }

    public String getChannellist() {
        return channellist;
    }

    public void setChannellist(String channellist) {
        this.channellist = channellist;
    }

    public long getBusid() {
        return busid;
    }

    public void setBusid(long busid) {
        this.busid = busid;
    }

    public boolean isPassengerflow() {
        return passengerflow;
    }

    public void setPassengerflow(boolean passengerflow) {
        this.passengerflow = passengerflow;
    }

    public TramBusInfo ConvertToBusInfo(){
        TramBusInfo busInfo = new TramBusInfo();
        busInfo.setBusframenumber(this.getBusframenumber());
        busInfo.setBusmode("");
        busInfo.setBusnumber(getBusnumber());
        busInfo.setBusplate("");
        busInfo.setBusstatus(1L);
        busInfo.setBustype(new Long(this.getBustype()));
        busInfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
        busInfo.setDepartmentid(this.getDepartmentid());
        busInfo.setDriverid(this.getDriverid());
        busInfo.setGuid(UUID.randomUUID().toString().replace("-",""));
        busInfo.setLineid(this.getLineid());
        busInfo.setId(this.getBusid());
        return busInfo;
    }

    public TramDeviceInfo ConvertToDeviceInfo(){
        TramDeviceInfo deviceInfo = new TramDeviceInfo();
        deviceInfo.setId(this.getId());
        deviceInfo.setAerialchannel(new Long(this.getAerialchannel()));
        deviceInfo.setAerialview(this.isAerialview());
        deviceInfo.setBarrier(this.isBarrier());
        deviceInfo.setBusid(this.getBusid());
        deviceInfo.setCan(this.isCan());
        deviceInfo.setCanbustypeid(1L);
        deviceInfo.setCarriagechannel(new Long(this.getCarriagechannel()));
        deviceInfo.setClientip(this.getClientip());
        deviceInfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
        deviceInfo.setDchannel(new Long(this.getDchannel()));
        deviceInfo.setDepartmentid(this.getDepartmentid());
        deviceInfo.setDevicecode(this.getDevicecode());
        deviceInfo.setDevicemode(this.getDevicemode());
        deviceInfo.setDevicename(this.getDevicename());
        deviceInfo.setDisksize(Long.valueOf(this.getDisksize()));
        deviceInfo.setGuid(UUID.randomUUID().toString().replace("_",""));
        deviceInfo.setDevicestatus(1L);
        deviceInfo.setHostsofttype(new Long(this.getHostsofttype()));
        deviceInfo.setIspositive(true);
        deviceInfo.setMachine("");
        deviceInfo.setLineid(this.getLineid());
        deviceInfo.setRadar(this.isRadar());
        deviceInfo.setSdcardsize(Long.valueOf(this.getSdcardsize()));
        deviceInfo.setSupportadas(this.isSupportadas());
        deviceInfo.setSpeeduse(1L);
        deviceInfo.setSupportbehavior(this.isSupportbehavior());
        deviceInfo.setVideochannel(new Long(this.getVideochannel()));
        deviceInfo.setVideosupport(this.isVideosupport());
        deviceInfo.setDevicetypeid(1L);
        deviceInfo.setPassengerflow(this.isPassengerflow());
        return deviceInfo;
    }
}
