package com.market.domain;

import java.util.Date;

public class CommisionConfiguration {

	private String id;
	private Short targetType;
	private String targetId;
	private Short calculateType;
	private Double calculateValue;
	private Object goodsId;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;
	private Boolean isDeleted;
	private int minSales;
	private int maxSales;
	private Short salesType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Short getTargetType() {
		return targetType;
	}

	public void setTargetType(Short targetType) {
		this.targetType = targetType;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public Short getCalculateType() {
		return calculateType;
	}

	public void setCalculateType(Short calculateType) {
		this.calculateType = calculateType;
	}

	public Double getCalculateValue() {
		return calculateValue;
	}

	public void setCalculateValue(Double calculateValue) {
		this.calculateValue = calculateValue;
	}

	public Object getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Object goodsId) {
		this.goodsId = goodsId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getMinSales() {
		return minSales;
	}

	public void setMinSales(int minSales) {
		this.minSales = minSales;
	}

	public int getMaxSales() {
		return maxSales;
	}

	public void setMaxSales(int maxSales) {
		this.maxSales = maxSales;
	}

	public short getSalesType() {
		return salesType;
	}

	public void setSalesType(Short salesType) {
		this.salesType = salesType;
	}

}