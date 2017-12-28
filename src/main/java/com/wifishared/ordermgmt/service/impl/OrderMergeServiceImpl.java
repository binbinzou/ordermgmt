package com.wifishared.ordermgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifishared.common.data.dto.user.LoginReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.data.otd.user.UserDeviceRsp;
import com.wifishared.common.framework.contant.CommonResultCodeConstant;
import com.wifishared.common.framework.contant.CommonResultMessageConstant;
import com.wifishared.common.framework.jwt.JwtManager;
import com.wifishared.common.framework.resultobj.GeneralContentResult;
import com.wifishared.ordermgmt.domain.OrderMerge;
import com.wifishared.ordermgmt.domain.OrderMergeHistory;
import com.wifishared.ordermgmt.repository.OrderMergeRepository;
import com.wifishared.ordermgmt.service.OrderMergeService;
import com.wifishared.ordermgmt.utils.OrderMergeConverter;

@Service
public class OrderMergeServiceImpl implements OrderMergeService{

	@Autowired
	OrderMergeRepository orderMergeRepository;
	
	@Override
	public GeneralContentResult<OrdersRspItem> queryNoMergenceOrders(String authorization) {
		GeneralContentResult<OrdersRspItem> result = new GeneralContentResult<OrdersRspItem>();
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage(CommonResultMessageConstant.OPERATE_SUCCESS);
		
		LoginReqBody reqBody = JwtManager.parseToken(authorization);
        String userId = reqBody.getUserId();
        String deviceId = reqBody.getDeviceId();
        List<OrderMerge> merges = orderMergeRepository.findByDeviceIdAndCreator(deviceId,userId);
        if(merges.size()==0) {
            result.setContent(null);
            return result;
        }
        OrdersRspItem ordersRspItems = new OrdersRspItem();
        for(OrderMerge merge : merges) {
        	ordersRspItems = OrderMergeConverter.orderMerge2OrdersRspItem(merge);
		}
        
        result.setContent(ordersRspItems);
		return result;
	}

}
