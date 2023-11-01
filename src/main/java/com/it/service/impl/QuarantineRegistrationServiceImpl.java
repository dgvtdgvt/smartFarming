package com.it.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.dao.ManagerBatchMapper;
import com.it.dao.QuarantineRegistrationMapper;
import com.it.dao.ext.QuarantineRegistrationExtMapper;
import com.it.exception.ServiceException;
import com.it.pojo.QuarantineRegistration;
import com.it.pojo.ext.QuarantineRegistrationExt;
import com.it.result.ResultCode;
import com.it.service.QuarantineRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class QuarantineRegistrationServiceImpl implements QuarantineRegistrationService {
    @Autowired
    private QuarantineRegistrationMapper quarantineRegistrationMapper;
    @Autowired
    private ManagerBatchMapper managerBatchMapper;
    @Autowired
    QuarantineRegistrationExtMapper quarantineRegistrationExtMapper;

    @Override
    public void saveOrUpdate(QuarantineRegistration qr) {
// 参数校验
        String grBatchId = qr.getGrBatchId();
        String bQualified = qr.getBQualified();
        if (!StringUtils.hasText(grBatchId) ||
                !StringUtils.hasText(qr.getGrMechanism()) ||
                !StringUtils.hasText(bQualified) ||
                !StringUtils.hasText(qr.getGrImg()) ||
                !StringUtils.hasText(qr.getGrTime())) {
            throw new ServiceException(ResultCode.PARAM_IS_EMPTY);
        }

        int result; // sql语句执行后，返回受影响的行数result
        if (qr.getGrId() != null) {
            // 有id->更新操作
            result = quarantineRegistrationMapper.updateByPrimaryKey(qr);
        } else {
            // 无id->新增操作
            result = quarantineRegistrationMapper.insert(qr);
        }
        if (result == 0) {
            throw new ServiceException(ResultCode.FAIL);
        }

        // 修改批次表中对应批次的检疫状态和检疫合格状态
        if (managerBatchMapper.updateBQuarantineAndBQualified(bQualified, grBatchId) == 0) {
            throw new ServiceException(ResultCode.FAIL);
        }
    }

    @Override
    public PageInfo<QuarantineRegistrationExt> findByPage(String grMechanism, String bQualified, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuarantineRegistrationExt> quarantineRegistrationExts = quarantineRegistrationExtMapper.queryAllRegistration(grMechanism, bQualified);
        PageInfo<QuarantineRegistrationExt> quarantineRegistrationExtPageInfo = new PageInfo<>(quarantineRegistrationExts);
        return quarantineRegistrationExtPageInfo;
    }

    @Override
    public void removeById(String id) {
        quarantineRegistrationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeBatch(List<String> ids) {
        quarantineRegistrationMapper.deleteBatch(ids);
    }
}
