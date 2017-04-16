package com.market.dao;

import com.market.domain.Order;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    int deleteByPrimaryKey(String id);

    int insert(Order record);

    Order selectByPrimaryKey(String id);

    List<Order> selectAll();
    
    int updateByPrimaryKey(Order record);
    
    List<Order> selectInPrimaryKeys(List<String> listOrderPrimaryKeys);
    
    List<Order> selectMany(@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("status")short status,
    		@Param("keyword")String keyword,
    		@Param("orderby")String orderby);
    
    int selectManyCount(@Param("status")short status,
    		@Param("keyword")String keyword);
}
