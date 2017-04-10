package com.market.dao;

import com.market.domain.OrderDetail;
import java.util.List;

public interface OrderDetailMapper {

    int deleteByPrimaryKey(String id);

    int insert(OrderDetail record);

    OrderDetail selectByPrimaryKey(String id);

    List<OrderDetail> selectAll();

    int updateByPrimaryKey(OrderDetail record);
    
    List<OrderDetail> selectInPrimaryKeys(List<String> listPrimaryKeys);
}