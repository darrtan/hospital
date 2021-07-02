package com.cheng.work.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.work.entity.Registration;
import com.cheng.work.mapper.RegistrationMapper;
import com.cheng.work.service.IRegistrationService;
import com.cheng.work.utils.QueryRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements IRegistrationService {

    @Resource
    private RegistrationMapper mapper;

    @Override
    public Integer selectByNow(Integer depId) {
        return mapper.selectByNow(depId);
    }

    @Override
    public IPage<Registration> queryList(Registration entity, QueryRequest queryRequest) {
        IPage<Registration> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryList(page, queryRequest, entity);
    }

    @Override
    public IPage<Registration> queryListByDoctor(Registration entity, QueryRequest queryRequest, Integer userId) {
        IPage<Registration> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryListByDoctor(page, queryRequest, entity, userId);
    }

    @Override
    public IPage<Registration> queryListByPatient(Registration entity, QueryRequest queryRequest, Integer userId) {
        IPage<Registration> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryListByPatient(page, queryRequest, entity, userId);
    }
}
