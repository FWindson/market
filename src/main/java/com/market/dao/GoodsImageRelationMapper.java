package com.market.dao;

import com.market.domain.GoodsImageRelation;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsImageRelationMapper {

    int deleteByPrimaryKey(String id);

    int insert(GoodsImageRelation record);

    GoodsImageRelation selectByPrimaryKey(String id);

    List<GoodsImageRelation> selectAll();

    int updateByPrimaryKey(GoodsImageRelation record);

    List<GoodsImageRelation> selectMany(@Param("goodsId")String goodsId,
    		@Param("imageId")String imageId);
}