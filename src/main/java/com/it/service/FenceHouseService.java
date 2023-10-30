package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.pojo.ManagerFenceHouse;
import com.it.pojo.ext.ManagerFenceHouseExt;

import java.util.List;

public interface FenceHouseService {
    PageInfo<ManagerFenceHouse> findByPage(String fhName, Integer pageNum, Integer pageSize);

    public void saveOrUpdate(ManagerFenceHouse managerFenceHouse);

    public void removeById(String fhId);

    public void removeBatch(List<String> ids);

    public ManagerFenceHouseExt findById(String id);
    public List<ManagerFenceHouse> findAll();
}
