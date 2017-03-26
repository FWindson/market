package com.market.dao.provider;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.market.dao.CompanyMapper;
import com.market.domain.Company;
import com.market.utils.MyBatisUtil;

@Repository("companyMapperProvider")
public class CompanyMapperProvider {

	public Company selectByPrimaryKey(String id) {
		SqlSession session = MyBatisUtil.getSession();
		CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
		return companyMapper.selectByPrimaryKey(id);
	}
	
}
