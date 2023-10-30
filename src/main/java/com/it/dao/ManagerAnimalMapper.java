package com.it.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ManagerAnimalMapper {
    Map<String, Integer> countWeight();
}