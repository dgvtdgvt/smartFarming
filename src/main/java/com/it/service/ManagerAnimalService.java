package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.pojo.ManagerAnimal;
import com.it.pojo.ext.ManagerAnimalExt;

import java.util.List;

public interface ManagerAnimalService {
    public PageInfo<ManagerAnimalExt> findByPage(Integer pageNum, int pageSize, String aHealthy, String aGender);
    public void saveOrUpdate(ManagerAnimal animal);
    void removeById(String id);
    void removeBatch(List<String> ids);

}
