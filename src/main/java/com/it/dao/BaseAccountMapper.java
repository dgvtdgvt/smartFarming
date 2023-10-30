package com.it.dao;

import com.it.pojo.BaseAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BaseAccountMapper {
    BaseAccount selectAccountInfo(@Param("username") String username,
                                 @Param("password") String password);
    BaseAccount selectByPrimaryKey(String accountId);
}