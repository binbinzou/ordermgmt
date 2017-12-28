package com.wifishared.ordermgmt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.data.otd.user.UserDeviceRsp;
import com.wifishared.common.framework.contant.CommonResultCodeConstant;
import com.wifishared.common.framework.contant.CommonResultMessageConstant;
import com.wifishared.common.framework.jwt.JwtManager;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import com.wifishared.ordermgmt.client.UserMgmtClient;
import com.wifishared.ordermgmt.domain.OrderMergeHistory;
import com.wifishared.ordermgmt.repository.OrderMergeHistoryRepository;
import com.wifishared.ordermgmt.service.OrderMergeHistoryService;
import com.wifishared.ordermgmt.utils.OrderMergeConverter;

@Service
public class OrderMergeHistoryServiceImpl implements OrderMergeHistoryService {

	@Autowired
	UserMgmtClient userMgmtClient;

	@Autowired
	OrderMergeHistoryRepository orderMergeHistoryRepository;

	@Override
	public GeneralContentResult<List<OrdersRspItem>> queryOrders(String authorization) {
		GeneralContentResult<List<OrdersRspItem>> result = new GeneralContentResult<List<OrdersRspItem>>();
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage(CommonResultMessageConstant.OPERATE_SUCCESS);
		
		List<OrdersRspItem> rspItems = new ArrayList<OrdersRspItem>();
		LoginReqBody reqBody = JwtManager.parseToken(authorization);

		String userId = reqBody.getUserId();
		List<OrderMergeHistory> mergeHistories = orderMergeHistoryRepository.findByCreator(userId);
		GeneralContentResult<List<UserDeviceRsp>> resultUserDevice = userMgmtClient.queryDevices(userId);
		List<UserDeviceRsp> rsps = resultUserDevice.getContent();
		Map<String, UserDeviceRsp> map = new HashMap<String, UserDeviceRsp>();
		if (rsps != null) {
			for (UserDeviceRsp rsp : rsps) {
				map.put(rsp.getId(), rsp);
			}
		}
		for(OrderMergeHistory mergeHistory : mergeHistories) {
			OrdersRspItem ordersRspItem = new OrdersRspItem();
			String deviceId = mergeHistory.getDeviceId();
			UserDeviceRsp deviceRsp = map.get(deviceId);
			ordersRspItem = OrderMergeConverter.mergeHistoryAndDeviceRsp2OrdersRspItem(mergeHistory, deviceRsp);
			rspItems.add(ordersRspItem);
		}
		result.setContent(rspItems);
		return result;
	}

	@Override
	public GeneralContentResult<OrdersRspItem> queryOrderByOrderId(String authorization,String orderId) {
		GeneralContentResult<OrdersRspItem> result = new GeneralContentResult<OrdersRspItem>();
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage(CommonResultMessageConstant.OPERATE_SUCCESS);
		OrderMergeHistory mergeHistory = orderMergeHistoryRepository.findOne(orderId);
		LoginReqBody reqBody = JwtManager.parseToken(authorization);
		String userId = reqBody.getUserId();
		GeneralContentResult<List<UserDeviceRsp>> resultUserDevice = userMgmtClient.queryDevices(userId);
		List<UserDeviceRsp> rsps = resultUserDevice.getContent();
		Map<String, UserDeviceRsp> map = new HashMap<String, UserDeviceRsp>();
		if (rsps != null) {
			for (UserDeviceRsp rsp : rsps) {
				map.put(rsp.getId(), rsp);
			}
		}
		String deviceId = mergeHistory.getDeviceId();
		UserDeviceRsp deviceRsp = map.get(deviceId);
		OrdersRspItem ordersRspItem = OrderMergeConverter.mergeHistoryAndDeviceRsp2OrdersRspItem(mergeHistory, deviceRsp);
		result.setContent(ordersRspItem);
		return result;
	}

}
