package com.market.dao;

import com.market.domain.CommisionConfiguration;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommisionConfigurationMapper {

    int deleteByPrimaryKey(String id);

    int insert(CommisionConfiguration record);

    CommisionConfiguration selectByPrimaryKey(String id);

    List<CommisionConfiguration> selectAll();

    int updateByPrimaryKey(CommisionConfiguration record);
    
    List<CommisionConfiguration> selectMany(@Param("goodsId")String goodsId,
    		@Param("targetType")int targetType,
    		@Param("targetId")String targetId,
    		@Param("orderby")String orderby);
    
    int selectManyCount(@Param("goodsId")String goodsId,
    		@Param("targetType")int targetType,
    		@Param("targetId")String targetId);
    
}