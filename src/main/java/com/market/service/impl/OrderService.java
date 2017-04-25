package com.market.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CustomerMapper;
import com.market.dao.GoodsImageRelationMapper;
import com.market.dao.GoodsMapper;
import com.market.dao.ImageMapper;
import com.market.dao.OrderDetailMapper;
import com.market.dao.OrderInfluenceMapper;
import com.market.dao.OrderMapper;
import com.market.domain.Customer;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;
import com.market.domain.Order;
import com.market.domain.OrderDetail;
import com.market.domain.OrderInfluence;
import com.market.java.extendsion.LinqArrayList;
import com.market.vo.OrderCompleteModel;
import com.market.vo.OrderDetailModel;
import com.market.vo.OrderModel;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

@Service
public class OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	CustomerMapper customerMapper;
	@Autowired
	OrderInfluenceMapper orderInfluenceMapper;
	@Autowired
	OrderDetailMapper orderDetailMapper;
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	GoodsImageRelationMapper goodsImageRelationMapper;
	@Autowired
	ImageMapper imageMapper;
	
	/**
	 * 获取OrderVO分页
	 * @param pageIndex
	 * @param pageSize
	 * @param status
	 * @param keyword
	 * @param orderby
	 * @return
	 */
	// TODO:根据customer_id
	public PageDataModel getOrders(String customerId,int pageIndex,int pageSize,short status,String keyword,String orderby){
		List<Order> listOrder = orderMapper.selectMany(customerId,pageIndex, pageSize, status, keyword, orderby);
		List<String> customerIds = new LinqArrayList<String>();
		List<OrderModel> listOrderModel = new LinqArrayList<OrderModel>();
		for(Order o : listOrder) {
			customerIds.add(o.getCustomerId());
		}
		LinqArrayList<Customer> customers = new LinqArrayList<Customer>(customerMapper.selectInPrimaryKeys(customerIds));
		// 拼装VO
		for(Order o : listOrder) {
			
			OrderModel orderModel = new OrderModel();
			orderModel.setId(o.getId());
			orderModel.setCode(o.getCode());
			orderModel.setStatus(o.getStatus());
			orderModel.setTotalPrice(o.getTotalPrice());
			orderModel.setCustomerId(o.getCustomerId());
			orderModel.setCreateTime(o.getCreateTime());

			Customer customer = customers.find(c -> c.getId().equals(o.getCustomerId()));
			
			orderModel.setCustomerName(customer.getName());
			listOrderModel.add(orderModel);
		}
		int count = orderMapper.selectManyCount(customerId,status, keyword);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, listOrderModel);
		return pageDataModel;
	}
	
	public ResponseModel getCompleteOrder(String orderId) {
		OrderCompleteModel orderCompleteModel = new OrderCompleteModel();
		OrderModel orderModel = new OrderModel();
		List<OrderDetailModel> orderDetailModels = new ArrayList<OrderDetailModel>(); 
		
		// 订单信息
		Order order = orderMapper.selectByPrimaryKey(orderId);
		orderModel.setId(order.getId());
		orderModel.setCode(order.getCode());
		orderModel.setStatus(order.getStatus());
		orderModel.setTotalPrice(order.getTotalPrice());
		orderModel.setCustomerId(order.getCustomerId());
		orderModel.setCreateTime(order.getCreateTime());
		Customer customer = customerMapper.selectByPrimaryKey(order.getCustomerId());
		orderModel.setCustomerName(customer.getName());
		// 订单折扣信息
		List<OrderInfluence> orderInfluences = orderInfluenceMapper.selectByOrderId(orderId);
		// 订单详情信息
		LinqArrayList<OrderDetail> orderDetails =  new LinqArrayList<OrderDetail>(orderDetailMapper.selectByOrderId(orderId));
		LinqArrayList<String> goodsIds = orderDetails.select(n -> n.getGoodsId());

		for(OrderDetail detail : orderDetails) {
			OrderDetailModel orderDetailModel = new OrderDetailModel();
			orderDetailModel.setId(detail.getId());
			orderDetailModel.setGoodsId(detail.getGoodsId());
			orderDetailModel.setGoodsName(detail.getGoodsName());
			orderDetailModel.setPrice(detail.getPrice());
			orderDetailModel.setQuantity(detail.getQuantity());
			orderDetailModel.setOriginalPrice(detail.getOriginalPrice());
			orderDetailModel.setTotalPrice(detail.getTotalPrice());
			
			LinqArrayList<GoodsImageRelation> listGoodsImageRelations = new LinqArrayList<>(goodsImageRelationMapper.selectMany(detail.getGoodsId(),""));
			List<String> imageIds = listGoodsImageRelations.select(relation -> relation.getImageId());
			LinqArrayList<Image> images = new LinqArrayList<>();
			if (imageIds.size() > 0) {
				images = new LinqArrayList<Image>(imageMapper.selectInPrimaryKeys(imageIds));
			}
			orderDetailModel.setImageUrls(images.select(image -> image.getRelativePath()));
			orderDetailModels.add(orderDetailModel);
		}
		
		orderCompleteModel.setOrder(orderModel);
		orderCompleteModel.setOrderInfluences(orderInfluences);
		orderCompleteModel.setOrderDetailModels(orderDetailModels);
		return ResponseModel.buildSuccess(orderCompleteModel);
	}
	
	public List<Order> getOrderByCustomerId(String customerId) {
		List<Order> orders =orderMapper.selectOrderByCustomerId(customerId);
		return orders;
	}

	
	public OrderDetail getOrderDetailByOrderId(String orderId) {
		OrderDetail orderDetail=orderDetailMapper.selectOrderDetailByOrderId(orderId);
		return orderDetail;
	}

}
