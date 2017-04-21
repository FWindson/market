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
    
    List<Sales> selectMany(@Param("companyId")String companyId,
    		@Param("status")Short[] status,
    		@Param("pageIndex")Integer pageIndex,
    		@Param("pageSize")Integer pageSize,
    		@Param("keyword")String keyword,
    		@Param("orderby")String orderby);
    
    int selectManyCount(@Param("companyId")String companyId,
    		@Param("status")Short[] status,
    		@Param("keyword")String keyword);
    
    List<Sales> selectInPrimaryKeys(List<String> list);
    
}