package com.market.dao;

import com.market.domain.CommisionRecord;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CommisionRecordMapper {

    int deleteByPrimaryKey(String id);

    int insert(CommisionRecord record);

    CommisionRecord selectByPrimaryKey(String id);

    List<CommisionRecord> selectAll();

    int updateByPrimaryKey(CommisionRecord record);
    
    List<CommisionRecord> selectMany(@Param("applicantType")int applicantType,
    		@Param("applicantId")String applicantId,
    		@Param("pageIndex")Integer pageIndex,
    		@Param("pageSize")Integer pageSize,
    		@Param("orderby")String orderby);
    
    int selectManyCount(@Param("applicantType")int applicantType,
    		@Param("applicantId")String applicantId);
    
}