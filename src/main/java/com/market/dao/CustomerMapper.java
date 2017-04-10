package com.market.dao;

import com.market.domain.Customer;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    Customer selectByPrimaryKey(String id);

    List<Customer> selectAll();
    
    int updateByPrimaryKey(Customer record);
    
    List<Customer> selectBySales(@Param("salesId")String salesId,
    		@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("keyword")String keyword,
    		@Param("orderby")String orderby);
    
    int selectCountBySales(@Param("salesId")String salesId,@Param("keyword")String keyword);
}