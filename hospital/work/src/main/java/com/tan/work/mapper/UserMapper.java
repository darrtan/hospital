package com.cheng.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cheng.work.entity.User;
import com.cheng.work.utils.QueryRequest;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    IPage<User> queryDoctorFuzz(IPage<User> userIPage, @Param("queryRequest") QueryRequest queryRequest, @Param("user") User user);

    User getDoctorInfoByUsername(@Param("username") String username);

}
