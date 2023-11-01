package com.it.dao;

import com.it.pojo.QuarantineRegistration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuarantineRegistrationMapper {
    int insert(QuarantineRegistration record);
    int updateByPrimaryKey(QuarantineRegistration record);

    void deleteByPrimaryKey(String grId);

    void deleteBatch(List<String> ids);
}