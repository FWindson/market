package com.market.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.market.dao.CompanyMapper;
import com.market.domain.BasicData;
import com.market.domain.CommisionConfiguration;
import com.market.domain.Company;
import com.market.service.ICompanyService;
import com.market.utils.BasicDataUtil;
import com.market.vo.CompanyModel;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

@Service("companyService")
public class CompanyService implements ICompanyService {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Override
	public Company getCompany(String name, String password) {
		return companyMapper.selectCompany(name, password);
	}

	@Override
	public List<Company> getAll() {
		return companyMapper.selectAll();
	}

	@Override
	public CompanyModel getByPrimaryKey(String id) {
		CompanyModel companyModel = new CompanyModel();
		Company company = companyMapper.selectByPrimaryKey(id);
		if (company == null) {
			companyModel = null;
		}
		else {
			companyModel.setId(company.getId());
			companyModel.setName(company.getName());
			companyModel.setStatus(company.getStatus());
			companyModel.setFund(company.getFund());
			companyModel.setFreezedFund(company.getFreezedFund());
			companyModel.setCreateTime(company.getCreateTime());
			companyModel.setCreateBy(company.getCreateBy());
			companyModel.setUpdateTime(company.getUpdateTime());
			companyModel.setUpdateBy(company.getUpdateBy());
		}
		return companyModel;
	}

	@Override
	public PageDataModel getCompanys(int pageIndex, int pageSize, String keyword, String orderby) {
		List<Company> list = companyMapper.selectMany(pageIndex, pageSize, keyword, orderby);
		int count = companyMapper.selectManyCount(pageIndex, pageSize, keyword, orderby);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, list);
		return pageDataModel;
	}

	@Override
	public ResponseModel createCompany(String name, String password,String creator) {
		ResponseModel model;
		Company company = new Company();
		try {
			company.setId(UUID.randomUUID().toString());
			company.setName(name);
			company.setPassword(password);
			company.setStatus((short)BasicDataUtil.CompanyStatus_Normal);
			company.setCreateTime(new Date());
			company.setCreateBy(creator);
			company.setFund(0.00);
			company.setFreezedFund(0.00);
			companyMapper.insert(company);
			model = ResponseModel.buildSuccess(company);
		} catch (Exception e) {
			// TODO: Log
			company = null;
			model = ResponseModel.buildFailed(e.getMessage());
		}
		return model;
	}
	

	public ResponseModel updateCompany(String companyId,String companyName,String password,String admin) {
		ResponseModel model = null;
		try {
			Company company = companyMapper.selectByPrimaryKey(companyId);
			company.setName(companyName);
			if (password != null && password != "") {
				company.setPassword(password);
			}
			company.setUpdateBy(admin);
			company.setUpdateTime(new Date());
			companyMapper.updateByPrimaryKey(company);
			model = ResponseModel.buildSuccess();
		} catch (Exception e) {
			//TODO:log
			model = ResponseModel.buildFailed(e.getMessage());
		}
		return model;
	}
	
	
}
