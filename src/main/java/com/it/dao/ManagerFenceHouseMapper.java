package com.it.dao;

import com.it.pojo.ManagerFenceHouse;
import com.it.pojo.ext.ManagerFenceHouseExt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerFenceHouseMapper {
    List<ManagerFenceHouse> queryAllHouses(String fhName);
    ManagerFenceHouse selectByFhName(String fhName);
    ManagerFenceHouse selectByPrimaryKey(String fhId);
    int updateByPrimaryKey(ManagerFenceHouse record);
    int insert(ManagerFenceHouse record);
    int deleteByPrimaryKey(String fhId);
    int deleteBatchByIds(List<String> ids);
    List<ManagerFenceHouse> selectAll();
    List<Object> countAllResources();

}