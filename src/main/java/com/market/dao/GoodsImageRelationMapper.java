package com.market.dao;

import com.market.domain.GoodsImageRelation;
import java.util.List;

public interface GoodsImageRelationMapper {

    int deleteByPrimaryKey(String id);

    int insert(GoodsImageRelation record);

    GoodsImageRelation selectByPrimaryKey(String id);

    List<GoodsImageRelation> selectAll();

    int updateByPrimaryKey(GoodsImageRelation record);
    
    List<GoodsImageRelation> selectByGoodsId(String goodsId);
}