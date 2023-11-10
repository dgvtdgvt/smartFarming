package com.it.dao;

import com.it.pojo.DiseaseRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiseaseRecordMapper {
    void deleteByPrimaryKey(String drId);

    void deleteBatch(List<String> ids);

    DiseaseRecord selectByPrimaryKey(Integer drId);
    int updateByPrimaryKey(DiseaseRecord diseaseRecord);
    int insert(DiseaseRecord diseaseRecord);
}