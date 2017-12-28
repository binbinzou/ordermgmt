package com.wifishared.ordermgmt.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the order_merge_history database table.
 * 
 */
@Entity
@Table(name="order_merge_history")
@NamedQuery(name="OrderMergeHistory.findAll", query="SELECT o FROM OrderMergeHistory o")
public class OrderMergeHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BEGIN_TIME")
	private Timestamp beginTime;

	@Column(name="DEVICE_ID")
	private String deviceId;
	
	@Column(name="CREATE_TIME")
	private Timestamp createTime;

	@Column(name="END_TIME")
	private Timestamp endTime;

	@Column(name="HOTSPOTCONFIG_ID")
	private String hotspotconfigId;

	@Column(name="SAVE_MONEY")
	private double saveMoney;

	@Column(name="SPEND_MONEY")
	private double spendMoney;
	
	@Column(name="NETWORK_ID")
	private String networkId;

	@Column(name="STATUS")
	private short status;

	@Column(name="CREATOR")
	private String creator;
	
	@Column(name="UPDATE_TIME")
	private Timestamp updateTime;

	@Column(name="WIFI_DATA_USEAGE")
	private BigInteger wifiDataUseage;

	public OrderMergeHistory() {
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getHotspotconfigId() {
		return this.hotspotconfigId;
	}

	public void setHotspotconfigId(String hotspotconfigId) {
		this.hotspotconfigId = hotspotconfigId;
	}

	public double getSaveMoney() {
		return this.saveMoney;
	}

	public void setSaveMoney(double saveMoney) {
		this.saveMoney = saveMoney;
	}

	public double getSpendMoney() {
		return this.spendMoney;
	}

	public void setSpendMoney(double spendMoney) {
		this.spendMoney = spendMoney;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public BigInteger getWifiDataUseage() {
		return this.wifiDataUseage;
	}

	public void setWifiDataUseage(BigInteger wifiDataUseage) {
		this.wifiDataUseage = wifiDataUseage;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}