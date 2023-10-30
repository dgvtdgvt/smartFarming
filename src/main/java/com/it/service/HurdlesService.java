package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.pojo.ManagerHurdles;
import com.it.pojo.ext.ManagerHurdlesExt;

import java.util.List;
import java.util.Map;

public interface HurdlesService {
    public List<Integer> findAllMax();
    public PageInfo<ManagerHurdlesExt> findByPage(Integer pageNum, Integer pageSize, String hName, Integer hMax, String fhName, String hEnable);
    public void modifyStatus(String hId, String hEnable);
    public void modifyStatusBatch(List<Map<String, String>> idAndStatus);
}
