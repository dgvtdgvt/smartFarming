package com.it.service;

import com.it.pojo.ManagerBatch;

import java.util.List;

public interface ManagerBatchService {
    public List<ManagerBatch> findAllUnquarantined();
    public List<ManagerBatch> findAll();
}
