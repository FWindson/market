package com.market.dao;

import com.market.domain.SalesApply;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SalesApplyMapper {

    int deleteByPrimaryKey(String id);

    int insert(SalesApply record);

    SalesApply selectByPrimaryKey(String id);

    List<SalesApply> selectAll();

    int updateByPrimaryKey(SalesApply record);
    
    List<SalesApply> selectByCompany(@Param("companyId")String companyId,
    		@Param("pageIndex")int pageIndex,
    		@Param("pageSize")int pageSize,
    		@Param("keyword")String keyword);
    
    @Select("select count(*) from sales_apply where company_id = #{companyId}::uuid")
    int selectCountByCompany(@Param("companyId")String companyId,
    		@Param("keyword")String keyword);
    
    List<SalesApply> selectInPrimaryKeys(List<String> salesApplyIds);
    
}