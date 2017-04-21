package com.market.dao;

import com.market.domain.User;
import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    List<User> selectInPrimaryKeys(List<String> userIds);
}