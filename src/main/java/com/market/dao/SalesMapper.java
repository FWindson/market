package com.market.dao;

import com.market.domain.Sales;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalesMapper {
	
    int deleteByPrimaryKey(String id);
    
    int insert(Sales record);
    
    Sales selectByPrimaryKey(String id);
    
    List<Sales> selectAll();
    
    int updateByPrimaryKey(Sales record);
    
    List<Sales> selectByCompany(@Param("companyId")String companyId,
    		@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("keyword")String keyword);
    
    int selectCountByCompany(@Param("companyId")String companyId,
    		@Param("keyword")String keyword);
}