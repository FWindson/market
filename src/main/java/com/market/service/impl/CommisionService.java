package com.market.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CommisionRecordMapper;
import com.market.dao.OrderDetailMapper;
import com.market.dao.OrderMapper;
import com.market.domain.CommisionRecord;
import com.market.domain.Order;
import com.market.domain.OrderDetail;
import com.market.vo.CommisionRecordModel;
import com.market.vo.PageDataModel;

@Service
public class CommisionService {

	@Autowired
	private CommisionRecordMapper commisionRecordMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Autowired
	private OrderMapper orderMapper;
	
	public PageDataModel getCommisionRecords(int applicantType,
    		String applicantId,
    		int pageIndex,
    		int pageSize,
    		String orderby){
		List<CommisionRecord> list = commisionRecordMapper.selectMany(applicantType, applicantId, pageIndex, pageSize,orderby);
		int count = commisionRecordMapper.selectManyCount(applicantType, applicantId);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, list);
		return pageDataModel;
	}
	
	public PageDataModel getCommisionRecordModels(int applicantType,
    		String applicantId,
    		int pageIndex,
    		int pageSize,
    		String orderby)
	{
		List<CommisionRecordModel> listResult = new ArrayList<>();
		
		List<CommisionRecord> listRecord = commisionRecordMapper.selectMany(applicantType, applicantId, pageIndex, pageSize,orderby);
		int count = commisionRecordMapper.selectManyCount(applicantType, applicantId);
		List<String> listOrderDetailId = new ArrayList<>();
		for(CommisionRecord record : listRecord){
			listOrderDetailId.add(record.getOrderDetailId());
		}
		List<OrderDetail> listOrderDetail = orderDetailMapper.selectInPrimaryKeys(listOrderDetailId);
		List<String> listOrderId = new ArrayList<String>();
		for(OrderDetail _od : listOrderDetail) {
			if(!listOrderId.contains(_od.getOrderId())){
				listOrderId.add(_od.getOrderId());
			}
		}
		List<Order> listOrder = orderMapper.selectInPrimaryKeys(listOrderId);
		
		for(CommisionRecord _record : listRecord) {
			CommisionRecordModel commisionRecordModel = new CommisionRecordModel();
			// 记录主键
			commisionRecordModel.setId(_record.getId());
			commisionRecordModel.setCreateTime(_record.getCreateTime());
			// 获得佣金
			commisionRecordModel.setNumber(_record.getNumber());
			for(OrderDetail _od : listOrderDetail) {
				if (_record.getOrderDetailId().equals(_od.getId())) {
					// 订单主键
					commisionRecordModel.setOrderId(_od.getOrderId());
					for(Order _o : listOrder) {
						if(_o.getId().equals(_od.getOrderId())){
							// 订单号
							commisionRecordModel.setOrderCode(_o.getCode());
						}
					}
					// 商品名
					commisionRecordModel.setGoodsName(_od.getGoodsName());
					// 数量
					commisionRecordModel.setQuantity(_od.getQuantity());
					// 总价
					commisionRecordModel.setTotalPrice(_od.getTotalPrice());
				}
			}
			listResult.add(commisionRecordModel);
		}
		PageDataModel dataModel = PageDataModel.buildSuccess(count, listResult);
		return dataModel;
	}
}
