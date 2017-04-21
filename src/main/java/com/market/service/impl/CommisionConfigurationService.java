package com.market.service.impl;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CommisionConfigurationMapper;
import com.market.dao.SalesMapper;
import com.market.domain.CommisionConfiguration;
import com.market.domain.Sales;
import com.market.requestmodel.CommisionConfigurationForm;
import com.market.requestmodel.CommisionConfigurationFormItem;
import com.market.utils.BasicDataUtil;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

@Service
public class CommisionConfigurationService {

	@Autowired
	CommisionConfigurationMapper commisionConfigurationMapper;
	@Autowired
	SalesMapper salesMapper;

	/**
	 * 设置规则
	 * @param form
	 * @param admin
	 * @return
	 */
	public ResponseModel setCommsionConfiguration(CommisionConfigurationForm form, String admin) {
		ResponseModel responseModel = null;
		List<CommisionConfiguration> list = new ArrayList<CommisionConfiguration>();
		try {
			List<CommisionConfigurationFormItem> listConfiguration = form.getCommisionConfigurations();
			for (CommisionConfigurationFormItem item : listConfiguration) {
				CommisionConfiguration configuration = null;
				if (item.getId() != null && !item.getId().equals("")) {
					configuration = this.commisionConfigurationMapper.selectByPrimaryKey(item.getId());
					if (configuration != null) {
						configuration.setCalculateType(item.getCalculateType());
						configuration.setCalculateValue(item.getCalculateValue());
						configuration.setUpdateTime(new Date());
						configuration.setUpdateBy(admin);
						configuration.setMinSales(item.getMinSales());
						configuration.setMaxSales(item.getMaxSales());
						configuration.setSalesType(item.getSalesType());
						commisionConfigurationMapper.updateByPrimaryKey(configuration);
					}
				}
				if (configuration == null) {
					configuration = new CommisionConfiguration();
					configuration.setId(UUID.randomUUID().toString());
					configuration.setTargetId(form.getTargetId());
					configuration.setTargetType(form.getTargetType());
					configuration.setCalculateType(item.getCalculateType());
					configuration.setCalculateValue(item.getCalculateValue());
					configuration.setGoodsId(item.getGoodsId());
					configuration.setCreateTime(new Date());
					configuration.setCreateBy(admin);
					configuration.setSalesType(item.getSalesType());
					configuration.setMinSales(item.getMinSales());
					configuration.setMaxSales(item.getMaxSales());
					configuration.setIsDeleted(false);
					commisionConfigurationMapper.insert(configuration);
				}
				list.add(configuration);
			}
			responseModel = ResponseModel.buildSuccess(list);
		} catch (Exception e) {
			//TODO:log
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return responseModel;
	}

	public PageDataModel getCommisionConfigurations(String goodsId,Short targetType,String targetId,String orderby){
		PageDataModel pageDataModel = null;
		List<CommisionConfiguration> list = commisionConfigurationMapper.selectMany(goodsId, targetType, targetId,  "");
		int count = commisionConfigurationMapper.selectManyCount(goodsId, targetType, targetId);
		pageDataModel = PageDataModel.buildSuccess(count, list);
		return pageDataModel;
	}

	public ResponseModel deleteCommisionConfiguration(String id) {
		ResponseModel model = null;
		try {
			commisionConfigurationMapper.deleteByPrimaryKey(id);
			model = ResponseModel.buildSuccess();
		} catch (Exception e) {
			//TODO:log
			model = ResponseModel.buildFailed(e.getMessage());
		}
		return model;
	}
	
}
