package com.cheng.work.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.work.entity.User;
import com.cheng.work.utils.QueryRequest;

public interface IUserService extends IService<User> {

    User selectByUsername(String username);

    IPage<User> queryFuzz(QueryRequest queryRequest, User user);

    IPage<User> queryDoctorFuzz(QueryRequest queryRequest, User user);

    IPage<User> queryPatiensFuzz(QueryRequest queryRequest, User user);

    User getDoctorInfoByUsername(String username);
}
