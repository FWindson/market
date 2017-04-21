package com.market.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.AdministratorMapper;
import com.market.dao.CompanyMapper;
import com.market.dao.SalesApplyMapper;
import com.market.domain.Administrator;
import com.market.domain.Company;
import com.market.domain.SalesApply;
import com.market.utils.LoggerUtil;
import com.market.vo.CompanyModel;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;
import com.market.vo.SalesApplyModel;

@Service
public class SalesApplyService {

	@Autowired
	private SalesApplyMapper salesApplyMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private AdministratorMapper administratorMapper;
	
	/**
	 * 获取公司销售员申请
	 * @param companyId
	 * @return
	 */
	public PageDataModel getSalesApplysByCompany(String companyId,Integer pageIndex,Integer pageSize,String keyword) {
		int count = salesApplyMapper.selectManyCount(companyId, null, keyword);
		List<SalesApply> list = salesApplyMapper.selectMany(companyId,null,keyword,"",pageIndex,pageSize);
		return PageDataModel.buildSuccess(count, list);
	}
	
	public PageDataModel getSalesApplys(String companyId,Short status,String keyword,String orderby,Integer pageIndex,Integer pageSize) {
		Short[] arrayStatus = null;
		if (status != null) {
			arrayStatus = new Short[] { status };
		}
		int count = salesApplyMapper.selectManyCount(companyId, arrayStatus, keyword);
		List<SalesApply> list = salesApplyMapper.selectMany(companyId,arrayStatus,keyword,"",pageIndex,pageSize);
		return PageDataModel.buildSuccess(count, list);
	}
	
	public ResponseModel getSalesApply(String salesApplyId) {
		SalesApplyModel salesApplyModel = new SalesApplyModel();
		SalesApply salesApply = salesApplyMapper.selectByPrimaryKey(salesApplyId);
		salesApplyModel.setId(salesApply.getId());
		salesApplyModel.setName(salesApply.getName());
		salesApplyModel.setUserId(salesApply.getUserId());
		salesApplyModel.setMobileNumber(salesApply.getMobileNumber());
		salesApplyModel.setComment(salesApply.getComment());
		salesApplyModel.setCompanyId(salesApply.getCompanyId());
		if (salesApply.getCompanyId() != "" && salesApply.getCompanyId() != null) {
			Company company = companyMapper.selectByPrimaryKey(salesApply.getCompanyId());
			salesApplyModel.setCompanyName(company.getName());
		}
		salesApplyModel.setStatus(salesApply.getStatus());
		salesApplyModel.setCreateTime(salesApply.getCreateTime());
		salesApplyModel.setUpdateTime(salesApply.getUpdateTime());
		salesApplyModel.setHandlerBy(salesApply.getHandlerBy());
		if (salesApply.getHandlerBy() != null && salesApply.getHandlerBy() != "") {
			Administrator administrator =  administratorMapper.selectByPrimaryKey(salesApply.getHandlerBy());
			salesApplyModel.setHandlerByName(administrator.getName());
		}
		ResponseModel responseModel = ResponseModel.buildSuccess(salesApplyModel);
		return responseModel;
	}
	
	public ResponseModel updateSalesApplyStatus(String salesApplyId,Short status,String handlerBy) {
		ResponseModel responseModel = null;
		try {
			SalesApply salesApply = salesApplyMapper.selectByPrimaryKey(salesApplyId);
			salesApply.setUpdateTime(new Date());
			salesApply.setStatus(status);
			salesApply.setHandlerBy(handlerBy);
			salesApplyMapper.updateByPrimaryKey(salesApply);
			responseModel = ResponseModel.buildSuccess();
		} catch (Exception e) {
			LoggerUtil.getLogger(this).error("更新销售员申请状态异常",e);
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return responseModel;
	}
	
}
