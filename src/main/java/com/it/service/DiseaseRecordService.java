package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.pojo.DiseaseRecord;
import com.it.pojo.ManagerDisease;
import com.it.pojo.ManagerHurdles;

import java.util.List;

public interface DiseaseRecordService {
    public List<ManagerDisease> queryAllDisease();

    PageInfo<DiseaseRecord> findByPage(Integer drDId,
                                       String drStatus,
                                       Integer pageNum,
                                       Integer pageSize);
    void removeById(String id);
    void removeBatch(List<String> ids);
    public void saveOrUpdate(DiseaseRecord diseaseRecord);
}
