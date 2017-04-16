package com.market.dao;

import com.market.domain.Goods;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {

    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    Goods selectByPrimaryKey(String id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
     
    List<Goods> selectMany(@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("keyword")String keyword,
    		@Param("orderby")String orderby);

    int selectManyCount(@Param("keyword")String keyword);
    
    List<Goods> selectInPrimaryKeys(List<String> goodsIds);
}