package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.dao.ManagerHurdlesMapper;
import com.it.exception.ServiceException;
import com.it.pojo.ManagerHurdles;
import com.it.pojo.ext.ManagerHurdlesExt;
import com.it.result.ResultCode;
import com.it.service.HurdlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class HurdlesServiceImpl implements HurdlesService {
    @Autowired
    ManagerHurdlesMapper managerHurdlesMapper;

    @Override
    public List<Integer> findAllMax() {
        return managerHurdlesMapper.selectAllMax();
    }

    @Override
    public PageInfo<ManagerHurdlesExt> findByPage(Integer pageNum, Integer pageSize, String hName, Integer hMax, String fhName, String hEnable) {
        PageHelper.startPage(pageNum, pageSize);
        List<ManagerHurdlesExt> list = managerHurdlesMapper.selectHurdlesAndFenceHouse(hName, hMax, fhName, hEnable);
        PageInfo<ManagerHurdlesExt> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void modifyStatus(String hId, String hEnable) {
        if (managerHurdlesMapper.selectByPrimaryKey(hId) != null) {
            String status = "可用";
            if (status.equals(hEnable)) {
                status = "禁用";
            }
            if (managerHurdlesMapper.updateHEnable(hId, status) == 0) {
                throw new ServiceException(ResultCode.FAIL);
            }
        } else {
            throw new ServiceException(ResultCode.DATA_IS_EMPTY);
        }
    }

    @Override
    public void modifyStatusBatch(List<Map<String, String>> idAndStatus) {
        int result = 0;
        for (Map<String, String> map : idAndStatus) {
            String hId = map.get("hId");
            if (managerHurdlesMapper.selectByPrimaryKey(hId) == null) {
                // 栏圈不存在，跳过本次循环
                continue;
            }
            String hEnable = map.get("hEnable");
            String status = "可用";
            if (status.equals(hEnable)) {
                status = "禁用";
            }
            result += managerHurdlesMapper.updateHEnable(hId, status);
        }
        if (result == 0) {
            throw new ServiceException(ResultCode.FAIL);
        }
    }

    @Override
    public List<ManagerHurdles> findAllEnable() {
        List<ManagerHurdles> allHurdles = managerHurdlesMapper.selectAllEnableHurdles();
        return allHurdles;
    }

    @Override
    public void saveOrUpdate(ManagerHurdles managerHurdles) {
        int result; // sql语句执行后，返回受影响的行数result
//        修改
        if (managerHurdles.getHId()!=null){
            ManagerHurdles managerHurdles1 = managerHurdlesMapper.selectByPrimaryKey(managerHurdles.getHId());
            if (managerHurdles1.getHSaved()>managerHurdles.getHMax()){
                throw new ServiceException(ResultCode.FAIL);
            }
            result = managerHurdlesMapper.updateByPrimaryKey(managerHurdles);
        }
//        新增
        else {
            managerHurdles.setHId(UUID.randomUUID().toString().replace("-", ""));
            result = managerHurdlesMapper.insert(managerHurdles);
        }
        // 添加或者修改失败
        if (result == 0) {
            throw new ServiceException(ResultCode.FAIL);
        }
    }

}
