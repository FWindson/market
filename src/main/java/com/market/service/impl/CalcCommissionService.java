package com.market.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CommisionRecordMapper;
import com.market.dao.OrderDetailMapper;
import com.market.dao.OrderInfluenceMapper;
import com.market.dao.OrderMapper;
import com.market.domain.CommisionRecord;
import com.market.domain.Goods;
import com.market.domain.Order;
import com.market.domain.OrderDetail;
import com.market.domain.OrderInfluence;
import com.market.service.ICalcCommissionService;

@Service("calcCommissionService")
public class CalcCommissionService implements ICalcCommissionService {
	
	
	@Autowired
    private OrderMapper orderMapper;
	
	@Autowired
    private OrderDetailMapper orderDetailMapper;
	
	@Autowired
    private OrderInfluenceMapper orderInfluenceMapper;
	
	@Autowired
    private CommisionRecordMapper commisionRecordMapper;

	@Override
	public Order addOrder(String code, double totalPrice, String customerId) {
		String id = UUID.randomUUID().toString();	
		Date date=new Date();
		Order order =new Order();
		order.setId(id);
		order.setCode(code);
		order.setCustomerId(customerId);
		order.setTotalPrice(totalPrice);
		order.setCreateTime(date);	
		orderMapper.insert(order);
		return order;		
	}

	@Override
	public OrderDetail addOrderDetail(Goods good, String imageId,String orderId,int quantity,double totalPrice) {
		String id = UUID.randomUUID().toString();	
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setGoodsId(good.getId());
		orderDetail.setGoodsName(good.getName());
		orderDetail.setId(id);
		orderDetail.setImageId(imageId);
		orderDetail.setOrderId(orderId);
		orderDetail.setOriginalPrice(0.0);
		orderDetail.setPrice(0.0);
		orderDetail.setQuantity(quantity);
		orderDetail.setTotalPrice(totalPrice);
		orderDetailMapper.insert(orderDetail);
		return orderDetail;
	}

	@Override
	public OrderInfluence addOrderInfluence(String orderId, short influenceType, double influenceValue) {
		OrderInfluence orderInfluence=new OrderInfluence();
		String id = UUID.randomUUID().toString();
		orderInfluence.setId(id);
		orderInfluence.setInfluenceType(influenceType);
		orderInfluence.setOrderId(orderId);
		orderInfluence.setInfluenceValue(influenceValue);
		orderInfluenceMapper.insert(orderInfluence); 
		return orderInfluence;
	}

	@Override
	public CommisionRecord addCommisionRecord() {
		String id = UUID.randomUUID().toString();
		CommisionRecord commisionRecord=new CommisionRecord();
		
		
		commisionRecordMapper.insert(commisionRecord);
		return commisionRecord;
	}
	
	
	
	

}
