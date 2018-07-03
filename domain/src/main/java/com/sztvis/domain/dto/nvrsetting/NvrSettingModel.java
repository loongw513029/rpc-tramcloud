package com.sztvis.domain.dto.nvrsetting;

import java.io.Serializable;
import java.util.List;

/**
 * NVR设置
 */
public class NvrSettingModel implements Serializable {
    private System system;
    private StoreCase storeCase;
    private List<Channels> channels;
    private Extend extend;

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public StoreCase getStoreCase() {
        return storeCase;
    }

    public void setStoreCase(StoreCase storeCase) {
        this.storeCase = storeCase;
    }

    public List<Channels> getChannels() {
        return channels;
    }

    public void setChannels(List<Channels> channels) {
        this.channels = channels;
    }

    public Extend getExtend() {
        return extend;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }

    /**
     * 系统设定
     */
    private static class System{
        private boolean reverseReg;
        private String forwardIp;
        private int packLapse;
        private boolean limitTime;
        private int limitTimeValue;
        private int preTimeValue;
        private int continueTimeValue;
        private int diskRetain;
        private boolean diskTempAutoCover;
        private boolean timeOutRemove;

        public boolean isReverseReg() {
            return reverseReg;
        }

        public void setReverseReg(boolean reverseReg) {
            this.reverseReg = reverseReg;
        }

        public String getForwardIp() {
            return forwardIp;
        }

        public void setForwardIp(String forwardIp) {
            this.forwardIp = forwardIp;
        }

        public int getPackLapse() {
            return packLapse;
        }

        public void setPackLapse(int packLapse) {
            this.packLapse = packLapse;
        }

        public boolean isLimitTime() {
            return limitTime;
        }

        public void setLimitTime(boolean limitTime) {
            this.limitTime = limitTime;
        }

        public int getLimitTimeValue() {
            return limitTimeValue;
        }

        public void setLimitTimeValue(int limitTimeValue) {
            this.limitTimeValue = limitTimeValue;
        }

        public int getPreTimeValue() {
            return preTimeValue;
        }

        public void setPreTimeValue(int preTimeValue) {
            this.preTimeValue = preTimeValue;
        }

        public int getContinueTimeValue() {
            return continueTimeValue;
        }

        public void setContinueTimeValue(int continueTimeValue) {
            this.continueTimeValue = continueTimeValue;
        }

        public int getDiskRetain() {
            return diskRetain;
        }

        public void setDiskRetain(int diskRetain) {
            this.diskRetain = diskRetain;
        }

        public boolean isDiskTempAutoCover() {
            return diskTempAutoCover;
        }

        public void setDiskTempAutoCover(boolean diskTempAutoCover) {
            this.diskTempAutoCover = diskTempAutoCover;
        }

        public boolean isTimeOutRemove() {
            return timeOutRemove;
        }

        public void setTimeOutRemove(boolean timeOutRemove) {
            this.timeOutRemove = timeOutRemove;
        }
    }

    /**
     * 存储方案
     */
    private static class StoreCase{
        private int storeType;
        private List<StoreInfo> storeInfo;

        public int getStoreType() {
            return storeType;
        }

        public void setStoreType(int storeType) {
            this.storeType = storeType;
        }

        public List<StoreInfo> getStoreInfo() {
            return storeInfo;
        }

        public void setStoreInfo(List<StoreInfo> storeInfo) {
            this.storeInfo = storeInfo;
        }
    }

    /**
     * 存储列表
     */
    private static class StoreInfo{
        private String name;
        private int totalSize;
        private boolean isRemovable;
        private boolean isAutoChannels;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public boolean isRemovable() {
            return isRemovable;
        }

        public void setRemovable(boolean removable) {
            isRemovable = removable;
        }

        public boolean isAutoChannels() {
            return isAutoChannels;
        }

        public void setAutoChannels(boolean autoChannels) {
            isAutoChannels = autoChannels;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    /**
     * 通道设置
     */
    private static class Channels{
        private int channelid;
        private boolean enable;
        private boolean preview;
        private String address;
        private String type;
        private String channelName;
        private int channelValue;
        private int videoCoverDay;
        private boolean singalLoss;
        private int resolution1;
        private int grameRate1;
        private int iinterval1;
        private int rateModel1;
        private int rate1;
        private boolean audio1;
        private int resolution2;
        private int grameRate2;
        private int iinterval2;
        private int rateModel2;
        private int rate2;
        private boolean audio2;

        public int getChannelid() {
            return channelid;
        }

        public void setChannelid(int channelid) {
            this.channelid = channelid;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public boolean isPreview() {
            return preview;
        }

        public void setPreview(boolean preview) {
            this.preview = preview;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public int getChannelValue() {
            return channelValue;
        }

        public void setChannelValue(int channelValue) {
            this.channelValue = channelValue;
        }

        public int getVideoCoverDay() {
            return videoCoverDay;
        }

        public void setVideoCoverDay(int videoCoverDay) {
            this.videoCoverDay = videoCoverDay;
        }

        public boolean isSingalLoss() {
            return singalLoss;
        }

        public void setSingalLoss(boolean singalLoss) {
            this.singalLoss = singalLoss;
        }

        public int getResolution1() {
            return resolution1;
        }

        public void setResolution1(int resolution1) {
            this.resolution1 = resolution1;
        }

        public int getGrameRate1() {
            return grameRate1;
        }

        public void setGrameRate1(int grameRate1) {
            this.grameRate1 = grameRate1;
        }

        public int getIinterval1() {
            return iinterval1;
        }

        public void setIinterval1(int iinterval1) {
            this.iinterval1 = iinterval1;
        }

        public int getRateModel1() {
            return rateModel1;
        }

        public void setRateModel1(int rateModel1) {
            this.rateModel1 = rateModel1;
        }

        public int getRate1() {
            return rate1;
        }

        public void setRate1(int rate1) {
            this.rate1 = rate1;
        }

        public boolean isAudio1() {
            return audio1;
        }

        public void setAudio1(boolean audio1) {
            this.audio1 = audio1;
        }

        public int getResolution2() {
            return resolution2;
        }

        public void setResolution2(int resolution2) {
            this.resolution2 = resolution2;
        }

        public int getGrameRate2() {
            return grameRate2;
        }

        public void setGrameRate2(int grameRate2) {
            this.grameRate2 = grameRate2;
        }

        public int getIinterval2() {
            return iinterval2;
        }

        public void setIinterval2(int iinterval2) {
            this.iinterval2 = iinterval2;
        }

        public int getRateModel2() {
            return rateModel2;
        }

        public void setRateModel2(int rateModel2) {
            this.rateModel2 = rateModel2;
        }

        public int getRate2() {
            return rate2;
        }

        public void setRate2(int rate2) {
            this.rate2 = rate2;
        }

        public boolean isAudio2() {
            return audio2;
        }

        public void setAudio2(boolean audio2) {
            this.audio2 = audio2;
        }
    }

    private static class Extend{
        private String code;
        private int gpsInterval;
        private Restart restart;
        private String platform;
        private String forwards;
        private boolean reverse;
        private int canType;
        private KeLiu keLiu;
        private Usarts usarts;
        private JCB jcb;
        private List<IoItem> io;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getGpsInterval() {
            return gpsInterval;
        }

        public void setGpsInterval(int gpsInterval) {
            this.gpsInterval = gpsInterval;
        }

        public Restart getRestart() {
            return restart;
        }

        public void setRestart(Restart restart) {
            this.restart = restart;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getForwards() {
            return forwards;
        }

        public void setForwards(String forwards) {
            this.forwards = forwards;
        }

        public boolean isReverse() {
            return reverse;
        }

        public void setReverse(boolean reverse) {
            this.reverse = reverse;
        }

        public int getCanType() {
            return canType;
        }

        public void setCanType(int canType) {
            this.canType = canType;
        }

        public KeLiu getKeLiu() {
            return keLiu;
        }

        public void setKeLiu(KeLiu keLiu) {
            this.keLiu = keLiu;
        }

        public Usarts getUsarts() {
            return usarts;
        }

        public void setUsarts(Usarts usarts) {
            this.usarts = usarts;
        }

        public JCB getJcb() {
            return jcb;
        }

        public void setJcb(JCB jcb) {
            this.jcb = jcb;
        }

        public List<IoItem> getIo() {
            return io;
        }

        public void setIo(List<IoItem> io) {
            this.io = io;
        }
    }

    /**
     * 重启
     */
    private static class Restart{
        private boolean isEnable;
        private String time;

        public boolean isEnable() {
            return isEnable;
        }

        public void setEnable(boolean enable) {
            isEnable = enable;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    /**
     * 客流
     */
    private static class KeLiu{
        private boolean isRealTime;
        private boolean isInterval;
        private int interval;
        private boolean enable;
        private int channel1;
        private int channel2;

        public boolean isRealTime() {
            return isRealTime;
        }

        public void setRealTime(boolean realTime) {
            isRealTime = realTime;
        }

        public boolean isInterval() {
            return isInterval;
        }

        public void setInterval(boolean interval) {
            isInterval = interval;
        }

        public int getInterval() {
            return interval;
        }

        public void setInterval(int interval) {
            this.interval = interval;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public int getChannel1() {
            return channel1;
        }

        public void setChannel1(int channel1) {
            this.channel1 = channel1;
        }

        public int getChannel2() {
            return channel2;
        }

        public void setChannel2(int channel2) {
            this.channel2 = channel2;
        }
    }

    private static class Usarts{
        private UsartItem xingWei;
        private UsartItem can;
        private UsartItem diaoDu;
        private UsartItem leiDa;
        private UsartItem quanJing;
        private UsartItem ADAS;

        public UsartItem getXingWei() {
            return xingWei;
        }

        public void setXingWei(UsartItem xingWei) {
            this.xingWei = xingWei;
        }

        public UsartItem getCan() {
            return can;
        }

        public void setCan(UsartItem can) {
            this.can = can;
        }

        public UsartItem getDiaoDu() {
            return diaoDu;
        }

        public void setDiaoDu(UsartItem diaoDu) {
            this.diaoDu = diaoDu;
        }

        public UsartItem getLeiDa() {
            return leiDa;
        }

        public void setLeiDa(UsartItem leiDa) {
            this.leiDa = leiDa;
        }

        public UsartItem getQuanJing() {
            return quanJing;
        }

        public void setQuanJing(UsartItem quanJing) {
            this.quanJing = quanJing;
        }

        public UsartItem getADAS() {
            return ADAS;
        }

        public void setADAS(UsartItem ADAS) {
            this.ADAS = ADAS;
        }
    }

    private static class UsartItem{
        private boolean enable;
        private String portName;
        private int baudRate;
        private int parity;
        private int dataBits;
        private int stopBits;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getPortName() {
            return portName;
        }

        public void setPortName(String portName) {
            this.portName = portName;
        }

        public int getBaudRate() {
            return baudRate;
        }

        public void setBaudRate(int baudRate) {
            this.baudRate = baudRate;
        }

        public int getParity() {
            return parity;
        }

        public void setParity(int parity) {
            this.parity = parity;
        }

        public int getDataBits() {
            return dataBits;
        }

        public void setDataBits(int dataBits) {
            this.dataBits = dataBits;
        }

        public int getStopBits() {
            return stopBits;
        }

        public void setStopBits(int stopBits) {
            this.stopBits = stopBits;
        }
    }

    private static class JCB{
        private int gpsInterval;
        private int dogInterval;
        private int gyroscope;
        private int acceleration;
        private int samplingRate;

        public int getGpsInterval() {
            return gpsInterval;
        }

        public void setGpsInterval(int gpsInterval) {
            this.gpsInterval = gpsInterval;
        }

        public int getDogInterval() {
            return dogInterval;
        }

        public void setDogInterval(int dogInterval) {
            this.dogInterval = dogInterval;
        }

        public int getGyroscope() {
            return gyroscope;
        }

        public void setGyroscope(int gyroscope) {
            this.gyroscope = gyroscope;
        }

        public int getAcceleration() {
            return acceleration;
        }

        public void setAcceleration(int acceleration) {
            this.acceleration = acceleration;
        }

        public int getSamplingRate() {
            return samplingRate;
        }

        public void setSamplingRate(int samplingRate) {
            this.samplingRate = samplingRate;
        }
    }

    private static class IoItem{
        private int source;
        private String sourceString;
        private int index;
        private int mode;
        private String modeString;
        private int type;

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public String getSourceString() {
            return sourceString;
        }

        public void setSourceString(String sourceString) {
            this.sourceString = sourceString;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getMode() {
            return mode;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        public String getModeString() {
            return modeString;
        }

        public void setModeString(String modeString) {
            this.modeString = modeString;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
