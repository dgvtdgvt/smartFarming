package com.it.dao;

import com.it.pojo.ManagerAnimal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManagerAnimalMapper {
    Map<String, Integer> countWeight();

    int insert(ManagerAnimal record);

    int updateByPrimaryKey(ManagerAnimal record);

    int updateAHealthyByAAnimalId(@Param("aHealthy") String aHealthy,
                                  @Param("aAnimalId") String aAnimalId);

    ManagerAnimal selectByPrimaryKey(String aAnimalId);

    void deleteByPrimaryKey(String id);

    void deleteBatch(List<String> ids);
}