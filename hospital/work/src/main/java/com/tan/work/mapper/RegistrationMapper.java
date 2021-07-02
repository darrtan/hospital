package com.cheng.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cheng.work.entity.Registration;
import com.cheng.work.utils.QueryRequest;
import org.apache.ibatis.annotations.Param;

public interface RegistrationMapper extends BaseMapper<Registration> {

    Integer selectByNow(@Param("depId") Integer depId);

    IPage<Registration> queryList(@Param("page") IPage<Registration> page, @Param("queryRequest") QueryRequest queryRequest, @Param("entity") Registration entity);

    IPage<Registration> queryListByDoctor(@Param("page") IPage<Registration> page, @Param("queryRequest") QueryRequest queryRequest, @Param("entity") Registration entity, @Param("userId") Integer userId);

    IPage<Registration> queryListByPatient(@Param("page") IPage<Registration> page, @Param("queryRequest") QueryRequest queryRequest, @Param("entity") Registration entity, @Param("userId") Integer userId);


}
