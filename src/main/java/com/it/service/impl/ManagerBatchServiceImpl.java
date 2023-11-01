package com.it.service.impl;

import com.it.dao.ManagerBatchMapper;
import com.it.pojo.ManagerBatch;
import com.it.service.ManagerBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerBatchServiceImpl implements ManagerBatchService {
    @Autowired
    ManagerBatchMapper managerBatchMapper;

    @Override
    public List<ManagerBatch> findAllUnquarantined() {
        List<ManagerBatch> managerBatches = managerBatchMapper.selectAllUnquarantined();
        return managerBatches;
    }

    @Override
    public List<ManagerBatch> findAll() {
        return managerBatchMapper.selectAllBatches();
    }
}
