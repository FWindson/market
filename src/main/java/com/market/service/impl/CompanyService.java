package com.market.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.market.dao.CompanyMapper;
import com.market.domain.Company;
import com.market.service.ICompanyService;

@Service("companyService")
public class CompanyService implements ICompanyService {

	@Autowired
	@Qualifier("companyDao")
	private CompanyMapper companyDao;
	
	@Override
	public Company getCompany(String name, String password) {
		return companyDao.selectCompany(name, password);
	}

	@Override
	public List<Company> getAll() {
		return companyDao.selectAll();
	}

	@Override
	public Company getByPrimaryKey(String id) {
		return companyDao.selectByPrimaryKey(id);
	}

}
