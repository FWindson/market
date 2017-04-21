package com.market.domain;

import java.util.Date;

public class Customer {

	private String id;
	private String name;
	private Object userId;
	private Date createTime;
	private String salesId;
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

	public Date getSetSalesTime() {
		return setSalesTime;
	}

	public void setSetSalesTime(Date setSalesTime) {
		this.setSalesTime = setSalesTime;
	}

}