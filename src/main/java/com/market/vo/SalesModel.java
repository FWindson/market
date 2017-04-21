package com.market.vo;

import java.util.Date;

public class SalesModel {

	private String id;
	private String name;
	private String userId;
	private Short status;
	private String companyId;
	private String companyName;
	private String mobileNumber;
	private Double commision;
	private Double freezeCommision;
	private Double totalCommision;
	private Date createTime;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(Double commision) {
		this.commision = commision;
	}

	public double getFreezeCommision() {
		return freezeCommision;
	}

	public void setFreezeCommision(Double freezeCommision) {
		this.freezeCommision = freezeCommision;
	}

	public double getTotalCommision() {
		return totalCommision;
	}

	public void setTotalCommision(Double totalCommision) {
		this.totalCommision = totalCommision;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
