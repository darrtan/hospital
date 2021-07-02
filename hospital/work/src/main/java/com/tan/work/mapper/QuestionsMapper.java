package com.cheng.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cheng.work.entity.Questions;
import com.cheng.work.utils.QueryRequest;
import org.apache.ibatis.annotations.Param;

public interface QuestionsMapper extends BaseMapper<Questions> {

    IPage<Questions> queryList(@Param("page") IPage<Questions> page, @Param("queryRequest") QueryRequest queryRequest, @Param("questions") Questions questions);

    IPage<Questions> queryListByPatient(@Param("page") IPage<Questions> page, @Param("queryRequest") QueryRequest queryRequest, @Param("questions") Questions questions, @Param("userId") Integer userId);
}
