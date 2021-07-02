package com.cheng.work.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cheng.work.entity.Questions;
import com.cheng.work.utils.QueryRequest;

public interface IQuestionsService extends IService<Questions> {

    IPage<Questions> queryList(QueryRequest queryRequest, Questions questions);

    IPage<Questions> queryListByPatient(QueryRequest queryRequest, Questions questions, Integer userId);
}
