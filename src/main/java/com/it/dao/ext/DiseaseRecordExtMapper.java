package com.it.dao.ext;

import com.it.pojo.ext.DiseaseRecordExt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiseaseRecordExtMapper {
    List<DiseaseRecordExt> queryAllRecords(Integer drDId, String drStatus);
}