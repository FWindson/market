package com.market.vo;

import java.util.List;

import com.market.domain.OrderInfluence;

public class OrderCompleteModel {

	private OrderModel order;
	private List<OrderInfluence> orderInfluences;
	private List<OrderDetailModel> orderDetailModels;

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}

	public List<OrderInfluence> getOrderInfluences() {
		return orderInfluences;
	}

	public void setOrderInfluences(List<OrderInfluence> orderInfluences) {
		this.orderInfluences = orderInfluences;
	}

	public List<OrderDetailModel> getOrderDetailModels() {
		return orderDetailModels;
	}

	public void setOrderDetailModels(List<OrderDetailModel> orderDetailModels) {
		this.orderDetailModels = orderDetailModels;
	}

}
