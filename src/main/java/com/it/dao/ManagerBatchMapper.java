package com.it.dao;

import com.it.pojo.ManagerBatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerBatchMapper {
    List<ManagerBatch> selectAllUnquarantined();

    int updateBQuarantineAndBQualified(
            @Param("bQualified") String bQualified,
            @Param("bSerialId") String bSerialId);

    List<ManagerBatch> selectAllBatches();

    ManagerBatch selectByPrimaryKey(String aBatchId);
}