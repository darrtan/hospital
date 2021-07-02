package com.cheng.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cheng.work.entity.Case;
import com.cheng.work.utils.QueryRequest;
import org.apache.ibatis.annotations.Param;

public interface CaseMapper extends BaseMapper<Case> {

    IPage<Case> queryList(@Param("page") IPage<Case> page, @Param("queryRequest") QueryRequest queryRequest, @Param("entity") Case entity);

    IPage<Case> queryListByPatient(@Param("page") IPage<Case> page, @Param("queryRequest") QueryRequest queryRequest, @Param("entity") Case entity, @Param("userId") Integer userId);
}
