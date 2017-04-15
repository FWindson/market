package com.market.dao;

import com.market.domain.Company;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {

    int deleteByPrimaryKey(String id);

    int insert(Company record);

    Company selectByPrimaryKey(String id);

    List<Company> selectAll();

    int updateByPrimaryKey(Company record);
    
    Company selectCompany(@Param("name")String name,@Param("password")String password);
    
    List<Company> selectMany(@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("keyword")String keyword,
    		@Param("orderby")String orderby);
    
    int selectManyCount(@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("keyword")String keyword,
    		@Param("orderby")String orderby);
}