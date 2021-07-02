package com.cheng.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.work.entity.Department;
import com.cheng.work.mapper.DepartmentMapper;
import com.cheng.work.service.IDepartmentService;
import com.cheng.work.utils.QueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {


    @Resource
    private DepartmentMapper mapper;

    @Override
    public IPage<Department> queryList(Department entity, QueryRequest queryRequest) {
        IPage<Department> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        LambdaQueryWrapper<Department> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasLength(entity.getLetter())) {
            lambdaQueryWrapper.like(Department::getLetter, entity.getLetter());
        }
        if (StringUtils.hasLength(entity.getDepName())) {
            lambdaQueryWrapper.like(Department::getDepName, entity.getDepName());
        }
        lambdaQueryWrapper.orderByDesc(Department::getCreateTime);
        return mapper.selectPage(page, lambdaQueryWrapper);
    }
}
