package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.pojo.QuarantineRegistration;
import com.it.pojo.ext.QuarantineRegistrationExt;
import com.it.result.Result;
import com.it.service.QuarantineRegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "检疫登记模块")
@RestController
@RequestMapping("/quarantineRegistration")
public class QuarantineController {
    @Autowired
    private QuarantineRegistrationService quarantineRegistrationService;

    @ApiOperation("分页多条件查询检疫登记信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grMechanism", value = "检疫机构"),
            @ApiImplicitParam(name = "bQualified", value = "检疫结果"),
            @ApiImplicitParam(name = "pageNum", value = "当前页码", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", defaultValue = "10", required = true)
    })
    @GetMapping("")
    public Result queryByConditionsAndPage(String grMechanism,
                                           String bQualified,
                                           Integer pageNum,
                                           Integer pageSize) {
        PageInfo<QuarantineRegistrationExt> byPage = quarantineRegistrationService.findByPage(grMechanism, bQualified, pageNum, pageSize);
        return Result.success(byPage);
    }

    @ApiOperation("新增或更新检疫记录接口")
    @PostMapping("/saveOrUpdate")
    public Result reviseRegistration(@RequestBody QuarantineRegistration qr) {
        quarantineRegistrationService.saveOrUpdate(qr);
        return Result.success();
    }

    @ApiOperation("根据id删除病疫记录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fhId", value = "栏舍编号", required = true)
    })
    @DeleteMapping("deleteById/{fhId}")
    public Result removeById(@PathVariable String fhId) {
        quarantineRegistrationService.removeById(fhId);
        return Result.success();
    }

    @ApiOperation("根据ids批量删除病疫记录接口")
    @DeleteMapping("/deleteByIdAll")
    public Result removeBatch(@RequestBody List<String> ids) {
        quarantineRegistrationService.removeBatch(ids);
        return Result.success();
    }

}
