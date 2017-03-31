package com.market.requestmodel;

import java.util.List;

import com.market.apicontroller.AdminApiController;

public class GoodsForm {
	
	private String name;
	private double price;
	private double marketPrice;
	private short status;
	private int stock;
	private String intro;
	private String description;
	private List<GoodsFormProduct> products;

	public String getName() {
		return name;
	}

	public List<GoodsFormProduct> getProducts() {
		return products;
	}

	public void setProducts(List<GoodsFormProduct> products) {
		this.products = products;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
