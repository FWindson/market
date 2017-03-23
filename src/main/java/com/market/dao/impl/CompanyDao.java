package com.market.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.market.dao.CompanyMapper;
import com.market.domain.Company;
import com.market.utils.MyBatisUtil;

@Repository("companyDao")
public class CompanyDao implements CompanyMapper {

	@Override
	public int deleteByPrimaryKey(Object id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Company selectByPrimaryKey(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Company selectCompany(String name, String password) {
		SqlSession session = MyBatisUtil.getSession();
		try {
			CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
			return companyMapper.selectCompany(name, password);
		} finally {
			session.close();
		}
	}

}
