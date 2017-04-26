package com.market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.market.domain.Order;

public interface OrderMapper {

    int deleteByPrimaryKey(String id);

    int insert(Order record);

    Order selectByPrimaryKey(String id);

    List<Order> selectAll();
    
    int updateByPrimaryKey(Order record);
    
    List<Order> selectInPrimaryKeys(List<String> listOrderPrimaryKeys);
    
    List<Order> selectMany(@Param("customerId")String customerId,
    		@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("status")short status,
    		@Param("keyword")String keyword,
    		@Param("orderby")String orderby);
    
    int selectManyCount(@Param("customerId")String customerId,
    		@Param("status")short status,
    		@Param("keyword")String keyword);

    List<Order> selectOrderByCustomerId(@Param("customerId")String customerId);
    
 
}
