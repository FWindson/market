package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.market.dao.CommisionRecordMapper;
import com.market.dao.CompanyMapper;
import com.market.dao.CustomerMapper;
import com.market.dao.SalesApplyMapper;
import com.market.dao.SalesMapper;
import com.market.dao.UserMapper;
import com.market.domain.CommisionRecord;
import com.market.domain.Company;
import com.market.domain.Sales;
import com.market.java.extendsion.LinqArrayList;
import com.market.utils.BasicDataUtil;
import com.market.utils.LoggerUtil;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;
import com.market.vo.SalesModel;

@Service
public class SalesService {

	@Autowired
	private SalesMapper salesMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private SalesApplyMapper salesApplyMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private CommisionRecordMapper commisionRecordMapper;

	/**
	 * 销售员列表
	 * 
	 * @param companyId
	 * @param status
	 * @param pageIndex
	 * @param pageSize
	 * @param keyword
	 * @param orderby
	 * @return
	 */
	public PageDataModel getSales(String companyId, Short status, Integer pageIndex, Integer pageSize, String keyword,
			String orderby) {
		Short[] arrayStatus = null;
		if (status != null) {
			arrayStatus = new Short[] { status };
		}
		List<Sales> listSales = salesMapper.selectMany(companyId,arrayStatus, pageIndex, pageSize, keyword,orderby);
		int count = salesMapper.selectManyCount(companyId, arrayStatus, keyword);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, listSales);
		return pageDataModel;
	}

	/**
	 * 销售员详情
	 * 
	 * @param salesId
	 * @return
	 */
	public ResponseModel getSalesModel(String salesId) {
		ResponseModel responseModel = null;
		try {
			SalesModel salesModel = new SalesModel();
			Sales sales = salesMapper.selectByPrimaryKey(salesId);
			salesModel.setId(sales.getId());
			salesModel.setName(sales.getName());
			salesModel.setUserId(sales.getUserId());
			salesModel.setCompanyId(sales.getCompanyId());
			salesModel.setStatus(sales.getStatus());
			Company company = companyMapper.selectByPrimaryKey(sales.getCompanyId());
			LinqArrayList<CommisionRecord> linqListCommisionRecord = new LinqArrayList<>(
					commisionRecordMapper.selectMany(BasicDataUtil.ApplicantType_Sales, salesId, null, null, ""));
			if (company != null) {
				salesModel.setCompanyName(company.getName());
			}
			double totalCommision = 0;
			List<Double> listCommision = linqListCommisionRecord.select(c -> c.getNumber());
			for (Double itemCommision : listCommision) {
				totalCommision += itemCommision;
			}
			salesModel.setTotalCommision(totalCommision);
			salesModel.setMobileNumber(sales.getMobileNumber());
			salesModel.setCommision(sales.getCommision());
			salesModel.setFreezeCommision(sales.getFreezedCommision());
			salesModel.setCreateTime(sales.getCreateTime());
			responseModel = ResponseModel.buildSuccess(salesModel);
		} catch (Exception e) {
			LoggerUtil.getLogger(this).error("获取销售员VO异常", e);
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return responseModel;
	}

	public ResponseModel getSalesDetail(String salesId) {
		ResponseModel responseModel;
		try {
			Sales sales = salesMapper.selectByPrimaryKey(salesId);
			if (sales != null) {
				responseModel = ResponseModel.buildSuccess(sales);
			} else {
				responseModel = ResponseModel.buildFailed("未找到该销售员");
			}
		} catch (Exception e) {
			LoggerUtil.getLogger(this).error("获取销售员详情异常", e);
			responseModel = ResponseModel.buildFailed(JSON.toJSONString(e));
		}
		return responseModel;
	}
	
	public List<Sales> getAllSales(String companyId){
		List<Sales> list=salesMapper.selectSalesByCompanyId(companyId);
		return list;


}
}