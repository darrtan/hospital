package com.cheng.work.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.work.entity.Case;
import com.cheng.work.mapper.CaseMapper;
import com.cheng.work.service.ICaseService;
import com.cheng.work.utils.QueryRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements ICaseService {

    @Resource
    private CaseMapper mapper;

    @Override
    public IPage<Case> queryList(Case entity, QueryRequest queryRequest) {
        IPage<Case> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryList(page, queryRequest, entity);
    }

    @Override
    public IPage<Case> queryListByPatient(Case entity, QueryRequest queryRequest, Integer userId) {
        IPage<Case> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryListByPatient(page, queryRequest, entity, userId);
    }

}
