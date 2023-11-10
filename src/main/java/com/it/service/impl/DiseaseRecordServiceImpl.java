package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.dao.DiseaseRecordMapper;
import com.it.dao.ManagerDiseaseMapper;
import com.it.dao.ext.DiseaseRecordExtMapper;
import com.it.exception.ServiceException;
import com.it.pojo.DiseaseRecord;
import com.it.pojo.ManagerDisease;
import com.it.pojo.ManagerHurdles;
import com.it.pojo.ext.DiseaseRecordExt;
import com.it.result.Result;
import com.it.result.ResultCode;
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

    @Override
    public void saveOrUpdate(DiseaseRecord diseaseRecord) {
        int result; // sql语句执行后，返回受影响的行数result
//        修改
        if (diseaseRecord.getDrId()!=null){
            result = diseaseRecordMapper.updateByPrimaryKey(diseaseRecord);
        }
//        新增
        else {
            result = diseaseRecordMapper.insert(diseaseRecord);
        }
        // 添加或者修改失败
        if (result == 0) {
            throw new ServiceException(ResultCode.FAIL);
        }
    }

}
