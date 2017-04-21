package com.market.service;

import java.util.List;

import com.market.domain.Company;
import com.market.vo.CompanyModel;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

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
	
	/**
	 * 获取公司
	 * @return 主键
	 */
	public CompanyModel getByPrimaryKey(String id);
	
	/**
	 * 获取公司列表
	 * @param pageIndex
	 * @param pageSize
	 * @param keyword
	 * @param orderby
	 * @return
	 */
	public PageDataModel getCompanys(int pageIndex,int pageSize,String keyword,String orderby);
	
	/**
	 * 新建公司
	 * @param name
	 * @param password
	 * @param creator
	 * @return
	 */
	public ResponseModel createCompany(String name,String password,String creator);
	
}
