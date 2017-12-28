package com.wifishared.ordermgmt.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the order_detail_history database table.
 * 
 */
@Entity
@Table(name="order_detail_history")
@NamedQuery(name="OrderDetailHistory.findAll", query="SELECT o FROM OrderDetailHistory o")
public class OrderDetailHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	@Column(name="DEVICE_ID")
	private String deviceId;
	
	@Column(name="CREATOR")
	private String creator;

	@Column(name="ORDER_DETAIL_TYPE")
	private short orderDetailType;

	@Column(name="ORDER_ID")
	private String orderId;

	@Column(name="WIFI_DATA")
	private BigInteger wifiData;

	public OrderDetailHistory() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public short getOrderDetailType() {
		return this.orderDetailType;
	}

	public void setOrderDetailType(short orderDetailType) {
		this.orderDetailType = orderDetailType;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigInteger getWifiData() {
		return this.wifiData;
	}

	public void setWifiData(BigInteger wifiData) {
		this.wifiData = wifiData;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}