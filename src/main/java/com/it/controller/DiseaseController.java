package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.pojo.DiseaseRecord;
import com.it.pojo.ManagerDisease;
import com.it.pojo.ManagerFenceHouse;
import com.it.result.Result;
import com.it.service.DiseaseRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "病症记录模块")
@RestController
@RequestMapping("/diseaseRecord")
public class DiseaseController {
    @Autowired
    DiseaseRecordService diseaseRecordService;


    @ApiOperation("分页多条件查询病症记录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "drDId", value = "病症id"),
            @ApiImplicitParam(name = "drStatus", value = "治疗状态"),
            @ApiImplicitParam(name = "pageNum", value = "当前页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "10", required = true)
    })
    @GetMapping("")
    public Result queryByConditionsAndPage(Integer drDId,
                                           String drStatus,
                                           Integer pageNum,
                                           Integer pageSize) {
        PageInfo<DiseaseRecord> byPage = diseaseRecordService.findByPage(drDId, drStatus, pageNum, pageSize);
        return Result.success(byPage);
    }

    @ApiOperation("查询全部病症接口")
    @GetMapping("/queryAllDisease")
    public Result queryAllDisease(){
        List<ManagerDisease> diseaseRecords = diseaseRecordService.queryAllDisease();
        return Result.success(diseaseRecords);
    }

    @ApiOperation("根据id删除病症记录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fhId", value = "栏舍编号", required = true)
    })
    @DeleteMapping("deleteById/{fhId}")
    public Result removeById(@PathVariable String fhId) {
        diseaseRecordService.removeById(fhId);
        return Result.success();
    }

    @ApiOperation("根据ids批量删除病症记录接口")
    @DeleteMapping("/deleteByIdAll")
    public Result removeBatch(@RequestBody List<String> ids) {
        diseaseRecordService.removeBatch(ids);
        return Result.success();
    }

    @ApiOperation("添加或修改病症记录接口")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody DiseaseRecord diseaseRecord){
        return null;
    }
}
