package com.wifishared.ordermgmt.utils;

import java.math.BigInteger;

import com.wifishared.common.data.dto.orderdetail.OrderDetailReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.data.otd.user.UserDeviceRsp;
import com.wifishared.ordermgmt.domain.OrderMerge;
import com.wifishared.ordermgmt.domain.OrderMergeHistory;

public class OrderMergeConverter {

	public static OrderMerge hotSpotReqBody2OrderMerge(OrderDetailReqBody reqBody){
		OrderMerge orderMerge = new OrderMerge();
		orderMerge.setHotspotconfigId(reqBody.getHotSpotId());
		orderMerge.setNetworkId(reqBody.getNetworkId());
		return orderMerge;
	}

	public static OrderMergeHistory orderMerge2History(OrderMerge merge) {
		OrderMergeHistory history = new OrderMergeHistory();
		history.setBeginTime(merge.getBeginTime());
		history.setDeviceId(merge.getDeviceId());
		history.setEndTime(merge.getEndTime());
		history.setHotspotconfigId(merge.getHotspotconfigId());
		history.setNetworkId(merge.getNetworkId());
		history.setSaveMoney(merge.getSaveMoney());
		history.setSpendMoney(merge.getSpendMoney());
		history.setStatus(merge.getStatus());
		history.setWifiDataUseage(merge.getWifiDataUseage());
		history.setCreateTime(merge.getCreateTime());
		history.setUpdateTime(merge.getUpdateTime());
		history.setCreator(merge.getCreator());
		return history;
	}
	
	public static OrdersRspItem mergeHistoryAndDeviceRsp2OrdersRspItem(OrderMergeHistory mergeHistory,UserDeviceRsp deviceRsp) {
		OrdersRspItem ordersRspItem = new OrdersRspItem();
		if(deviceRsp!=null) {
			ordersRspItem.setDeviceId(deviceRsp.getId());
			ordersRspItem.setDeviceUuid(deviceRsp.getDeviceId());
			ordersRspItem.setDeviceName(deviceRsp.getDevideName());
		}else {
			ordersRspItem.setDeviceId(null);
			ordersRspItem.setDeviceUuid(null);
			ordersRspItem.setDeviceName("不详");
		}
		ordersRspItem.setId(mergeHistory.getId());
		ordersRspItem.setHotSpotId(mergeHistory.getHotspotconfigId());
		ordersRspItem.setSaveMoney(String.valueOf(mergeHistory.getSaveMoney()));
		ordersRspItem.setSpendMoney(String.valueOf(mergeHistory.getSpendMoney()));
		ordersRspItem.setBeginTime(String.valueOf(mergeHistory.getBeginTime().getTime()));
		ordersRspItem.setEndTime(String.valueOf(mergeHistory.getEndTime().getTime()));
		ordersRspItem.setSpendTime(String.valueOf(mergeHistory.getEndTime().getTime()-mergeHistory.getBeginTime().getTime()));
		ordersRspItem.setWifiDataUseage(String.valueOf(mergeHistory.getWifiDataUseage()));
		return ordersRspItem;
	}
	
	public static OrdersRspItem mergeAndDeviceRsp2OrdersRspItem(OrderMerge merge,UserDeviceRsp deviceRsp) {
		OrdersRspItem ordersRspItem = new OrdersRspItem();
		if(deviceRsp!=null) {
			ordersRspItem.setDeviceId(deviceRsp.getId());
			ordersRspItem.setDeviceUuid(deviceRsp.getDeviceId());
			ordersRspItem.setDeviceName(deviceRsp.getDevideName());
		}else {
			ordersRspItem.setDeviceId(null);
			ordersRspItem.setDeviceUuid(null);
			ordersRspItem.setDeviceName("不详");
		}
		ordersRspItem.setId(merge.getId());
		ordersRspItem.setHotSpotId(merge.getHotspotconfigId());
		ordersRspItem.setNetworkId(merge.getNetworkId());
		ordersRspItem.setSaveMoney(String.valueOf(merge.getSaveMoney()));
		ordersRspItem.setSpendMoney(String.valueOf(merge.getSpendMoney()));
		ordersRspItem.setBeginTime(String.valueOf(merge.getBeginTime().getTime()));
		ordersRspItem.setEndTime(String.valueOf(merge.getEndTime().getTime()));
		ordersRspItem.setSpendTime(String.valueOf(merge.getEndTime().getTime()-merge.getBeginTime().getTime()));
		ordersRspItem.setWifiDataUseage(String.valueOf(merge.getWifiDataUseage()));
		return ordersRspItem;
	}

	public static OrdersRspItem orderMerge2OrdersRspItem(OrderMerge merge) {
		OrdersRspItem ordersRspItem = new OrdersRspItem();
		ordersRspItem.setId(merge.getId());
		ordersRspItem.setHotSpotId(merge.getHotspotconfigId());
		return ordersRspItem;
	}
	
}
