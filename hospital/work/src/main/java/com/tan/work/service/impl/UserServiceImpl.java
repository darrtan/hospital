package com.cheng.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.work.entity.User;
import com.cheng.work.mapper.UserMapper;
import com.cheng.work.service.IUserService;
import com.cheng.work.utils.QueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper mapper;

    @Override
    public User selectByUsername(String username) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, username);
        return mapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public IPage<User> queryFuzz(QueryRequest queryRequest, User user) {
        IPage<User> userIPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getRoleId, 0)
                .like(!StringUtils.isEmpty(user.getUsername()), User::getUsername, user.getUsername())
                .like(!StringUtils.isEmpty(user.getMobile()), User::getMobile, user.getMobile())
                .between(!StringUtils.isEmpty(queryRequest.getBeginTime()) && !StringUtils.isEmpty(queryRequest.getEndTime()), User::getCreateTime, queryRequest.getBeginTime(), queryRequest.getEndTime())
                .orderByDesc(User::getCreateTime);
        return mapper.selectPage(userIPage, lambdaQueryWrapper);
    }

    @Override
    public IPage<User> queryDoctorFuzz(QueryRequest queryRequest, User user) {
        IPage<User> userIPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryDoctorFuzz(userIPage, queryRequest, user);
//        IPage<User> userIPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getRoleId, 1)
//                .like(!StringUtils.isEmpty(user.getUsername()), User::getUsername, user.getUsername())
//                .like(!StringUtils.isEmpty(user.getMobile()), User::getMobile, user.getMobile())
//                .between(!StringUtils.isEmpty(queryRequest.getBeginTime()) && !StringUtils.isEmpty(queryRequest.getEndTime()), User::getCreateTime, queryRequest.getBeginTime(), queryRequest.getEndTime())
//                .orderByDesc(User::getCreateTime);
//        return mapper.selectPage(userIPage, lambdaQueryWrapper);
    }

    @Override
    public IPage<User> queryPatiensFuzz(QueryRequest queryRequest, User user) {
        IPage<User> userIPage = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getRoleId, 2)
                .like(!StringUtils.isEmpty(user.getUsername()), User::getUsername, user.getUsername())
                .like(!StringUtils.isEmpty(user.getMobile()), User::getMobile, user.getMobile())
                .between(!StringUtils.isEmpty(queryRequest.getBeginTime()) && !StringUtils.isEmpty(queryRequest.getEndTime()), User::getCreateTime, queryRequest.getBeginTime(), queryRequest.getEndTime())
                .orderByDesc(User::getCreateTime);
        return mapper.selectPage(userIPage, lambdaQueryWrapper);
    }

    @Override
    public User getDoctorInfoByUsername(String username) {
        return mapper.getDoctorInfoByUsername(username);
    }
}
