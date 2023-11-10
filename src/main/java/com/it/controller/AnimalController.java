package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.pojo.ManagerAnimal;
import com.it.pojo.ext.ManagerAnimalExt;
import com.it.result.Result;
import com.it.service.ManagerAnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "动物管理模块")
@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private ManagerAnimalService managerAnimalService;
    @ApiOperation("分页多条件查询动物信息以及对应批次和栏圈信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "10", required = true),
            @ApiImplicitParam(name = "aHealthy", value = "健康状态"),
            @ApiImplicitParam(name = "aGender", value = "动物性别"),
    })
    @GetMapping("")
    public Result getAnimalRelated(Integer pageNum, int pageSize, String aHealthy, String aGender) {
        PageInfo<ManagerAnimalExt> result = managerAnimalService.findByPage(pageNum, pageSize, aHealthy, aGender);
        return Result.success(result);
    }

    @ApiOperation("新增或修改动物接口")
    @PostMapping("/saveOrUpdate")
    public Result reviseAnimalInfo(@RequestBody ManagerAnimal animal) {
        managerAnimalService.saveOrUpdate(animal);
        return Result.success();
    }

    @ApiOperation("根据栏舍编号删除栏舍信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fhId", value = "栏舍编号", required = true)
    })
    @DeleteMapping("deleteById/{fhId}")
    public Result removeById(@PathVariable String fhId) {
        managerAnimalService.removeById(fhId);
        return Result.success();
    }

    @ApiOperation("批量删除栏舍接口")
    @DeleteMapping("/deleteByIdAll")
    public Result removeBatch(@RequestBody List<String> ids) {
        managerAnimalService.removeBatch(ids);
        return Result.success();
    }
}
