package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.pojo.ManagerFenceHouse;
import com.it.pojo.QuarantineRegistration;
import com.it.pojo.ext.QuarantineRegistrationExt;

import java.util.List;

public interface QuarantineRegistrationService {
    public void saveOrUpdate(QuarantineRegistration qr);
    PageInfo<QuarantineRegistrationExt> findByPage(String grMechanism, String bQualified, Integer pageNum, Integer pageSize);
    void removeById(String id);
    void removeBatch(List<String> ids);
}
