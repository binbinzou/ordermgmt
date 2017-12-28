package com.wifishared.ordermgmt.constant;

public class OrderMgmtConstant {

	//wifi热点
	public static short ORDER_DETAIL_TYPE_BEGIN = 1;  
	//手机热点
	public static short ORDER_DETAIL_TYPE_END = 2; 
	
	//主订单生成中
	public static short ORDER_MERGE_BEGINING = 1; 
	//订单待评价
	public static short ORDER_MERGE_UNCOMMENT = 2;
	
	
	
	public static String ORDER_MERGE_QUEUE = "order.merge";
	
	
	//计费模式
	public static String CHARING_MODULE_QUANTITY = "1";
	public static String CHARING_MOUDLE_TIME = "2";
	public static String CHARING_MODULE_FREE = "3";
	//流量计费
	public static double MONEY_EVERY_OMEN = 0.28;
}
