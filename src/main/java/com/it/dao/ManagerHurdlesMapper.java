package com.it.dao;

import com.it.pojo.ManagerHurdles;
import com.it.pojo.ext.ManagerHurdlesExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ManagerHurdlesMapper {
    int selectCountByFhId(String fhId);
    List<Integer> selectAllMax();

    List<ManagerHurdlesExt> selectHurdlesAndFenceHouse(
            @Param("hName") String hName,
            @Param("hMax") Integer hMax,
            @Param("fhName") String fhName,
            @Param("hEnable") String hEnable);

    int updateHEnable(@Param("hId") String hId,
                      @Param("hEnable") String hEnable);

    public ManagerHurdles selectByPrimaryKey(String hId);

    List<ManagerHurdles> selectAllEnableHurdles();

    int updateByPrimaryKey(ManagerHurdles managerHurdles);
}
