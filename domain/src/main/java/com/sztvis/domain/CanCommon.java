package com.sztvis.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/12 上午11:45
 */
public class CanCommon {
    /**
     * 传统车辆CAN对照表
     */
    public static Map<Integer,String> NormalCANContrast = new HashMap<Integer,String>(){{
        put(0,"");
        put(1,"batteryvoltage");
        put(2,"batterycurrent");
        put(3,"busstall");
        put(4,"baterysoc");
        put(5,"motorspeed");
        put(6,"enginefuelrae");
        put(7,"solardoor");
        put(8,"gasusetotal");
        put(9,"totalmileage");
        put(10,"shortmileage");
        put(11,"fueleconomy");
        put(12,"fuelusespeed");
        put(13,"oilpressure");
        put(14,"pressure1");
        put(15,"pressure2");
        put(16,"remainingoil");
        put(17,"speed");
        put(18,"watertemperature");
        put(19,"rotationalspeed");
        put(20,"totaloilconsumption");
        put(21,"voltage");
        put(22,"tirelayoutnumber");
        put(23,"tirenumber1");
        put(24,"tirepressure1");
        put(25,"tirenumber2");
        put(26,"tirepressure2");
        put(87,"incartemperature");
        put(88,"outcartemperature");
    }};

    /**
     * BMS纯电动车辆CAN对照表
     */
    public static Map<Integer,String> BmsCANContrast = new HashMap<Integer,String>(){{
        put(200,"batterySingleCount");
        put(201,"batteryProbeCount");
        put(202,"batteryMaxVoltageSingleCode");
        put(203,"batteryMaxVoltage");
        put(204,"batteryMinVoltageCode");
        put(205,"batteryMinVoltage");
        put(206,"maxTempProbeNumber");
        put(207,"maxTempValue");
        put(208,"minTempProbeNumber");
        put(209,"minTempValue");
        put(217,"highResistance");
        put(218,"electrical");
        put(219,"leftElecRote");
        put(220,"leftElecInputVoltage");
        put(221,"leftElecTemp");
        put(222,"leftElecContrTemp");
        put(223,"rightElecRote");
        put(224,"rightElecInputVoltage");
        put(225,"rightELecTemp");
        put(226,"rightElecContrTemp");
        put(227,"rightElecTorque");
        put(228,"rightElecMode");
        put(229,"leftElecTorque");
        put(230,"leftElecMode");
        put(231,"leftElecCurrent");
        put(232,"rightElecCurrent");
        put(233,"acceleratorPedal");
        put(234,"carVIN");
        put(235,"idlingSwitch");
        put(236,"minimumBatteryNumber");
        put(237,"allBatteryMinimum");
        put(238,"maxmumBatteryNumber");
        put(239,"allBatteryMax");
        put(240,"minimumTempBatteryNumber");
        put(241,"minimumTemp");
        put(242,"maxTempBatteryNumber");
        put(243,"maxTemp");
        put(244,"chargeSurplusHour");
        put(245,"chargeSurplusMinute");
        put(246,"signleChargeValue");
        put(247,"signleDisChargeValue");
        put(251,"batteryTempState");
        put(252,"leakageState");
        put(256,"mxElec");
        put(257,"setTemp");
        put(258,"airState");
        put(263,"okState");
        put(264,"shieldTurnState");
    }};
}
