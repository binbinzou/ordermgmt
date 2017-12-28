package com.wifishared.ordermgmt.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.math.BigInteger;


/**
 * The persistent class for the order_comment database table.
 * 
 */
@Entity
@Table(name="order_comment")
@NamedQuery(name="OrderComment.findAll", query="SELECT o FROM OrderComment o")
public class OrderComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="HOTSPOTCONFIG_ID")
	private String hotspotconfigId;

	@Column(name="ORDER_HISTORY_ID")
	private BigInteger orderHistoryId;

	@Column(name="SCORE")
	private short score;

	public OrderComment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getHotspotconfigId() {
		return this.hotspotconfigId;
	}

	public void setHotspotconfigId(String hotspotconfigId) {
		this.hotspotconfigId = hotspotconfigId;
	}

	public BigInteger getOrderHistoryId() {
		return this.orderHistoryId;
	}

	public void setOrderHistoryId(BigInteger orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public short getScore() {
		return this.score;
	}

	public void setScore(short score) {
		this.score = score;
	}

}