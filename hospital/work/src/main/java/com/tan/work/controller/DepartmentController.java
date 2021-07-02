package com.cheng.work.controller;

import com.cheng.work.annotation.AdminLoginToken;
import com.cheng.work.entity.Department;
import com.cheng.work.service.IDepartmentService;
import com.cheng.work.utils.QueryRequest;
import com.cheng.work.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 医院科室表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/adminApi/department")
public class DepartmentController {


    @Autowired
    private IDepartmentService departmentService;

    /**
     * 查询医院科室列表
     */
    @GetMapping("/list")
    public ResultVo list(Department entity, QueryRequest queryRequest) {

        return ResultVo.oK(departmentService.queryList(entity, queryRequest));
    }

    /**
     * 获取医院科室详细信息
     */
    @GetMapping(value = "/{id}")
    public ResultVo getInfo(@PathVariable("id") Integer id) {
        return ResultVo.oK(departmentService.getById(id));
    }

    /**
     * 新增医院科室
     */
    @PostMapping
    public ResultVo add(@RequestBody Department entity) {
        departmentService.save(entity);
        return ResultVo.oK();
    }

    /**
     * 修改医院科室
     */
    @PutMapping
    @AdminLoginToken
    public ResultVo edit(@RequestBody Department entity) {
        departmentService.updateById(entity);
        return ResultVo.oK();
    }

    /**
     * 删除医院科室
     */
    @DeleteMapping("/{ids}")
    public ResultVo remove(@PathVariable Integer[] ids) {
        departmentService.removeByIds(Arrays.asList(ids));
        return ResultVo.oK();
    }

}
