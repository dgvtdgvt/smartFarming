package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.pojo.ManagerFenceHouse;
import com.it.pojo.ManagerHurdles;
import com.it.pojo.ext.ManagerHurdlesExt;

import java.util.List;
import java.util.Map;

public interface HurdlesService {
    public List<Integer> findAllMax();
    /**
     * 条件分页查询
     * @param pageNum 每页数量
     * @param pageSize 每页数量
     * @param hName 栏圈名称
     * @param hMax 最大值
     * @param fhName 栏舍名称
     * @param hEnable 启用状态
     * @return PageInfo<ManagerHurdlesExt> 对象
     */
    public PageInfo<ManagerHurdlesExt> findByPage(Integer pageNum, Integer pageSize, String hName, Integer hMax, String fhName, String hEnable);

    /**
     * 修改障碍物的状态
     * @param hId 栏圈ID
     * @param hEnable 启用状态
     */
    public void modifyStatus(String hId, String hEnable);

    public void modifyStatusBatch(List<Map<String, String>> idAndStatus);
    public List<ManagerHurdles> findAllEnable();
    public void saveOrUpdate(ManagerHurdles managerHurdles);
}
