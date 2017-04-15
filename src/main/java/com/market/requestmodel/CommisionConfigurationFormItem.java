package com.market.requestmodel;

public class CommisionConfigurationFormItem {

	private String id;
	private short calculateType;
	private double calculateValue;
	private int minSales;
	private int maxSales;
	private short salesType;
	private String goodsId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCalculateValue() {
		return calculateValue;
	}

	public void setCalculateValue(double calculateValue) {
		this.calculateValue = calculateValue;
	}

	public short getCalculateType() {
		return calculateType;
	}

	public void setCalculateType(short calculateType) {
		this.calculateType = calculateType;
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

	public void setSalesType(short salesType) {
		this.salesType = salesType;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

}
