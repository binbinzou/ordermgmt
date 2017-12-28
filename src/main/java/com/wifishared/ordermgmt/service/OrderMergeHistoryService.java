package com.wifishared.ordermgmt.service;

import java.util.List;

import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

public interface OrderMergeHistoryService {

	GeneralContentResult<List<OrdersRspItem>> queryOrders(String authorization);

	GeneralContentResult<OrdersRspItem> queryOrderByOrderId(String authorization,String orderId);

}
