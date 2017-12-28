package com.wifishared.ordermgmt.utils;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import com.wifishared.common.data.otd.hotspot.HotSpotRspBody;
import com.wifishared.ordermgmt.constant.OrderMgmtConstant;
import com.wifishared.ordermgmt.domain.OrderDetail;
import com.wifishared.ordermgmt.domain.OrderMerge;

import lombok.extern.slf4j.Slf4j;

/**
 * 订单计算工具类
 * @author binbin
 *
 */
@Slf4j
public class OrderMergeDataCalculate {
	

	public static OrderMerge calculate(OrderDetail begin,OrderDetail end,OrderMerge orderMerge,HotSpotRspBody rspBody) {
		DecimalFormat df   =new DecimalFormat("#.00");  
		Timestamp beginTime = begin.getUpdateTime();
		Timestamp endTime = end.getUpdateTime();
		orderMerge.setBeginTime(beginTime);
		orderMerge.setEndTime(endTime);
		BigInteger beginData = begin.getWifiData();
		BigInteger endData = end.getWifiData();
		//计算spend money、save money、wifidata useage
		//计算使用了多少M,连接多少分钟
		BigInteger wifiDataUseage = endData.subtract(beginData);
		BigInteger big1024Integer = new BigInteger("1024");
		double dataUseageOMEN = wifiDataUseage.divide(big1024Integer).divide(big1024Integer).doubleValue();
		long connectTime = (endTime.getTime() - beginTime.getTime())/1000/60;//计算连接分钟
		
		orderMerge.setWifiDataUseage(wifiDataUseage);
		String charingModule = rspBody.getCharingModule();//计费模式 
		String charingStandard = rspBody.getCharingStandard();//计费标准
		if(OrderMgmtConstant.CHARING_MOUDLE_TIME.equals(charingModule)) {
			double moneyEveryMinute = Double.parseDouble(charingStandard)/60;//计算每分钟多少钱
			double actualDataSpend = dataUseageOMEN * OrderMgmtConstant.MONEY_EVERY_OMEN;
			double actualTimeSpend = connectTime * moneyEveryMinute;
			log.info("dataUseageOMEN:{};actualDataSpend:{};realDataSpend:{}",dataUseageOMEN,actualDataSpend,actualTimeSpend);
			if(actualDataSpend > actualTimeSpend) {//节省了多少钱。
				orderMerge.setSpendMoney(Double.parseDouble(df.format(actualTimeSpend)));
				orderMerge.setSaveMoney(Double.parseDouble(df.format(actualDataSpend-actualTimeSpend)));
				orderMerge.setStatus(OrderMgmtConstant.ORDER_MERGE_UNCOMMENT);
			}else {//没节省钱
				orderMerge.setSpendMoney(Double.parseDouble(df.format(actualTimeSpend)));
				orderMerge.setSaveMoney(0);
				orderMerge.setStatus(OrderMgmtConstant.ORDER_MERGE_UNCOMMENT);
			}
		}else if(OrderMgmtConstant.CHARING_MODULE_QUANTITY.equals(charingModule)) {
			double moneyEveryOMEN = 1/Float.parseFloat(charingStandard);//计算每M多少钱
			double actualDataSpend = dataUseageOMEN * OrderMgmtConstant.MONEY_EVERY_OMEN;
			double realDataSpend = dataUseageOMEN * moneyEveryOMEN;
			log.info("dataUseageOMEN:{};actualDataSpend:{};realDataSpend:{}",dataUseageOMEN,actualDataSpend,realDataSpend);
			if(actualDataSpend>realDataSpend) {//节省了多少钱。
				orderMerge.setSpendMoney(Double.parseDouble(df.format(realDataSpend)));
				orderMerge.setSaveMoney(Double.parseDouble(df.format(actualDataSpend-realDataSpend)));
				orderMerge.setStatus(OrderMgmtConstant.ORDER_MERGE_UNCOMMENT);
			}else {//没节省钱
				orderMerge.setSpendMoney(Double.parseDouble(df.format(realDataSpend)));
				orderMerge.setSaveMoney(0);
				orderMerge.setStatus(OrderMgmtConstant.ORDER_MERGE_UNCOMMENT);
			}
		}else if(OrderMgmtConstant.CHARING_MODULE_FREE.equals(charingModule)) {
			double actualDataSpend = dataUseageOMEN * OrderMgmtConstant.MONEY_EVERY_OMEN;
			orderMerge.setSpendMoney(0);
			orderMerge.setSaveMoney(actualDataSpend);
			orderMerge.setStatus(OrderMgmtConstant.ORDER_MERGE_UNCOMMENT);
		}
		return orderMerge;
	}
	
}
