package com.market.vo;

import java.util.Date;

public class SalesApplyModel {

	private String id;
	private String userId;
	private String name;
	private String mobileNumber;
	private String comment;
	private String companyId;
	private String companyName;
	private Short status;
	private Date createTime;
	private Date updateTime;
	private String handlerBy;
	private String handlerByName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHandlerBy() {
		return handlerBy;
	}

	public void setHandlerBy(String handlerBy) {
		this.handlerBy = handlerBy;
	}

	public String getHandlerByName() {
		return handlerByName;
	}

	public void setHandlerByName(String handlerByName) {
		this.handlerByName = handlerByName;
	}

}
