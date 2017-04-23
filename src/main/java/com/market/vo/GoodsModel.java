package com.market.vo;

import com.market.domain.Goods;
import com.market.domain.Image;

public class GoodsModel {
	
	private String goodsId;  //商品Id
	
	private String goodName;   //商品名称
	
	private double goodPrice; //商品价格 
	
	private String description; //商品描述
	
	private String imageName; //图片名称
	
	private String imagePath;  //图片路径
	
	
	public GoodsModel(Goods good,Image image){
		  this.goodsId=good.getId();
		  this.description=good.getDescription();
		  this.goodName=good.getName();
		  this.imageName=image.getFileName();
		  this.imagePath=image.getRelativePath();
		  this.goodPrice=good.getPrice();
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}



	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public double getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	


}
