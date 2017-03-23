package com.market.service;

import java.util.List;

import com.market.domain.Company;

public interface ICompanyService {

	/**
	 * 获取公司
	 * @param name 公司名
	 * @param password 密码
	 * @return
	 */
	public Company getCompany(String name,String password);
	
	/**
	 * 获取全部
	 * @return
	 */
	public List<Company> getAll();
	
}
