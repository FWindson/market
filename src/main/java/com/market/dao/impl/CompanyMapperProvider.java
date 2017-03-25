package com.market.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.market.dao.CompanyMapper;
import com.market.domain.Company;
import com.market.utils.MyBatisUtil;

@Repository("companyDao")
public class CompanyMapperProvider implements CompanyMapper {

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Company record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Company selectByPrimaryKey(String id) {
		SqlSession session = MyBatisUtil.getSession();
		CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
		return companyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Company> selectAll() {
		SqlSession session = MyBatisUtil.getSession();
		return session.selectList("com.market.dao.CompanyMapper.selectAll");
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
