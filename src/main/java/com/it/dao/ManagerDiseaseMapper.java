package com.it.dao;

import com.it.pojo.DiseaseRecord;
import com.it.pojo.ManagerDisease;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManagerDiseaseMapper {
    List<Map<String, Object>> countDisease();

    List<ManagerDisease> queryAllDisease();

}