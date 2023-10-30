package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.dao.ManagerHurdlesMapper;
import com.it.exception.ServiceException;
import com.it.pojo.ext.ManagerHurdlesExt;
import com.it.result.ResultCode;
import com.it.service.HurdlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
}
