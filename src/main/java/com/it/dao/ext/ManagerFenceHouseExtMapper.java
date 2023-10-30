package com.it.dao.ext;

import com.it.pojo.ext.ManagerFenceHouseExt;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface ManagerFenceHouseExtMapper {
    ManagerFenceHouseExt selectHouseAndHurdlesById(String fhId);
}