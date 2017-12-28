package com.wifishared.ordermgmt.service;

import com.wifishared.common.data.dto.orderdetail.OrderDetailReqBody;
import com.wifishared.common.data.otd.order.OrdersRspItem;
import com.wifishared.common.framework.resultobj.GeneralContentResult;

public interface OrderDetailService {

	GeneralContentResult<String> createOrderDetail( String authorization,OrderDetailReqBody orderDetailReqBody);

	GeneralContentResult<OrdersRspItem> createOrderDetailForResult(String authorization,
			OrderDetailReqBody orderDetailReqBody);

}
