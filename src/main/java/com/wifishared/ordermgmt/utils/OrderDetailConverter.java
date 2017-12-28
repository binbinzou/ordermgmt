package com.wifishared.ordermgmt.utils;

import java.math.BigInteger;

import com.wifishared.common.data.dto.orderdetail.OrderDetailReqBody;
import com.wifishared.ordermgmt.domain.OrderDetail;
import com.wifishared.ordermgmt.domain.OrderDetailHistory;

public class OrderDetailConverter {

	public static OrderDetail hotSpotReqBody2Hotspotconfig(OrderDetailReqBody reqBody){
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderDetailType(Short.parseShort(reqBody.getType()));
		orderDetail.setWifiData(BigInteger.valueOf(Long.parseLong(reqBody.getWifiData())));
		return orderDetail;
	}
	
	public static OrderDetailHistory orderDetail2History(OrderDetail orderDetail) {
		OrderDetailHistory history = new OrderDetailHistory();
		history.setUpdateTime(orderDetail.getUpdateTime());
		history.setCreator(orderDetail.getCreator());
		history.setDeviceId(orderDetail.getDeviceId());
		history.setOrderDetailType(orderDetail.getOrderDetailType());
		history.setOrderId(orderDetail.getOrderId());
		history.setWifiData(orderDetail.getWifiData());
		return history;
	}

}
