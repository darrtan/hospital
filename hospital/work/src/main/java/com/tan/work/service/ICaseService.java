package com.cheng.work.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.work.entity.Case;
import com.cheng.work.utils.QueryRequest;

public interface ICaseService extends IService<Case> {

    IPage<Case> queryList(Case entity, QueryRequest queryRequest);

    IPage<Case> queryListByPatient(Case entity, QueryRequest queryRequest, Integer userId);
}
