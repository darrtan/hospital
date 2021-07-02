package com.cheng.work.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.work.entity.Department;
import com.cheng.work.utils.QueryRequest;

public interface IDepartmentService extends IService<Department> {

    IPage<Department> queryList(Department entity, QueryRequest queryRequest);

}
