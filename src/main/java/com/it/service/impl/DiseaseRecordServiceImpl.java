package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.dao.DiseaseRecordMapper;
import com.it.dao.ManagerDiseaseMapper;
import com.it.dao.ext.DiseaseRecordExtMapper;
import com.it.pojo.DiseaseRecord;
import com.it.pojo.ManagerDisease;
import com.it.pojo.ext.DiseaseRecordExt;
import com.it.result.Result;
import com.it.service.DiseaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseRecordServiceImpl implements DiseaseRecordService {
    @Autowired
    DiseaseRecordMapper diseaseRecordMapper;

    @Autowired
    ManagerDiseaseMapper managerDiseaseMapper;

    @Autowired
    DiseaseRecordExtMapper diseaseRecordExtMapper;

    @Override
    public List<ManagerDisease> queryAllDisease() {
        return managerDiseaseMapper.queryAllDisease();
    }

    @Override
    public PageInfo<DiseaseRecord> findByPage(Integer drDId, String drStatus, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<DiseaseRecordExt> diseaseRecordExts = diseaseRecordExtMapper.queryAllRecords(drDId, drStatus);
        PageInfo<DiseaseRecord> diseaseRecordPageInfo = new PageInfo<>(diseaseRecordExts);
        return diseaseRecordPageInfo;
    }

    @Override
    public void removeById(String id) {
        diseaseRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeBatch(List<String> ids) {
        diseaseRecordMapper.deleteBatch(ids);
    }
}
