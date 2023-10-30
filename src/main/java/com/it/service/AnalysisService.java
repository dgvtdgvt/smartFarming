package com.it.service;

import java.util.List;
import java.util.Map;

public interface AnalysisService {
    public Map<String, List<Object>> countNum();
    public Map<String, Integer> countWeight();
    public Map<String, Long> countDisease();
    public Map<String, List<Object>> countSales();
}
