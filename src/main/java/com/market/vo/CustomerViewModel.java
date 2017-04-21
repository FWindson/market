package com.market.vo;

import java.util.Date;

public class CustomerViewModel {

	private String id;
	private String name;
	private Object userId;
	private Date createTime;
	private String salesId;
	private String salesName;
	private Date setSalesTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public Date getSetSalesTime() {
		return setSalesTime;
	}

	public void setSetSalesTime(Date setSalesTime) {
		this.setSalesTime = setSalesTime;
	}

}
