package com.cheng.work.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.work.entity.Registration;
import com.cheng.work.utils.QueryRequest;

public interface IRegistrationService extends IService<Registration> {

    Integer selectByNow(Integer depId);

    IPage<Registration> queryList(Registration entity, QueryRequest queryRequest);

    IPage<Registration> queryListByDoctor(Registration entity, QueryRequest queryRequest, Integer userId);

    IPage<Registration> queryListByPatient(Registration entity, QueryRequest queryRequest, Integer userId);

}
