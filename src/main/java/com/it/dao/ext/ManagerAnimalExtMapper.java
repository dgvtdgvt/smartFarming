package com.it.dao.ext;

import com.it.pojo.ext.ManagerAnimalExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ManagerAnimalExtMapper {
    List<ManagerAnimalExt> selectAnimalRelated(
            @Param("aHealthy") String aHealthy,
            @Param("aGender") String aGender);
}
