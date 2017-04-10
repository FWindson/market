package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.SalesApplyMapper;
import com.market.domain.SalesApply;
import com.market.vo.PageDataModel;

@Service
public class SalesApplyService {

	@Autowired
	private SalesApplyMapper salesApplyMapper;
	
	/**
	 * 获取公司销售员申请
	 * @param companyId
	 * @return
	 */
	public PageDataModel getSalesApplysByCompany(String companyId,int pageIndex,int pageSize,String keyword) {
		int count = salesApplyMapper.selectCountByCompany(companyId,keyword);
		List<SalesApply> list = salesApplyMapper.selectByCompany(companyId,pageIndex,pageSize,keyword);
		return PageDataModel.buildSuccess(count, list);
	}
	
}
