package com.market.dao;

import com.market.domain.OrderInfluence;
import java.util.List;

public interface OrderInfluenceMapper {

    int deleteByPrimaryKey(String id);

    int insert(OrderInfluence record);

    OrderInfluence selectByPrimaryKey(String id);

    List<OrderInfluence> selectAll();

    int updateByPrimaryKey(OrderInfluence record);
    
    List<OrderInfluence> selectByOrderId(String orderId);
}