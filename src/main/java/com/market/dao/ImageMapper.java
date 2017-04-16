package com.market.dao;

import com.market.domain.Image;
import java.util.List;

public interface ImageMapper {

    int deleteByPrimaryKey(String id);

    int insert(Image record);

    Image selectByPrimaryKey(String id);

    List<Image> selectAll();

    int updateByPrimaryKey(Image record);
    
    List<Image> selectInPrimaryKeys(List<String> imageIds);
}