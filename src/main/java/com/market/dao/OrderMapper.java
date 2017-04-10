package com.market.dao;

import com.market.domain.Order;
import java.util.List;

public interface OrderMapper {

    int deleteByPrimaryKey(String id);

    int insert(Order record);

    Order selectByPrimaryKey(String id);

    List<Order> selectAll();
    
    int updateByPrimaryKey(Order record);
    
    List<Order> selectInPrimaryKeys(List<String> listOrderPrimaryKeys);
}