package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.pojo.ManagerFenceHouse;
import com.it.pojo.ext.ManagerFenceHouseExt;
import com.it.result.Result;
import com.it.service.FenceHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "栏舍管理模块")
@RestController
@RequestMapping("/fenceHouse")
public class FenceHouseController {

    @Autowired
    private FenceHouseService fenceHouseService;

    @ApiOperation("分页多条件查询栏舍信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fhName", value = "栏舍名称"),
            @ApiImplicitParam(name = "pageNum", value = "当前页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "10", required = true),
    })
    @GetMapping("")
    public Result queryByConditionsAndPage(String fhName, Integer pageNum, Integer pageSize) {
        PageInfo<ManagerFenceHouse> result = fenceHouseService.findByPage(fhName, pageNum, pageSize);
        return Result.success(result);
    }

    @ApiOperation("新增或修改栏舍接口")
    @PostMapping("/saveOrUpdate")
    public Result reviseFenceHouses(@RequestBody ManagerFenceHouse managerFenceHouse) {
        fenceHouseService.saveOrUpdate(managerFenceHouse);
        return Result.success();
    }

    @ApiOperation("根据栏舍编号删除栏舍信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fhId", value = "栏舍编号", required = true)
    })
    @DeleteMapping("/{fhId}")
    public Result removeById(@PathVariable String fhId) {
        fenceHouseService.removeById(fhId);
        return Result.success();
    }

    @ApiOperation("批量删除栏舍接口")
    @DeleteMapping("/deleteByIdAll")
    public Result removeBatch(@RequestBody List<String> ids) {
        fenceHouseService.removeBatch(ids);
        return Result.success();
    }

    @ApiOperation("根据栏舍编号查询栏舍信息以及栏圈信息接口")
    @GetMapping("/{fhId}")
    public Result queryRelativeDetails(@PathVariable String fhId){
        ManagerFenceHouseExt result = fenceHouseService.findById(fhId);
        return Result.success(result);
    }

    @ApiOperation("查询所有的栏舍信息")
    @GetMapping("/queryAll")
    public Result queryAll() {
        return Result.success(fenceHouseService.findAll());
    }

}