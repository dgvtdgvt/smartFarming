package com.it.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManagerDiseaseMapper {
    List<Map<String, Object>> countDisease();

}