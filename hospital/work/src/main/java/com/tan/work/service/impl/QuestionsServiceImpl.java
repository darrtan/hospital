package com.cheng.work.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cheng.work.entity.Questions;
import com.cheng.work.mapper.QuestionsMapper;
import com.cheng.work.service.IQuestionsService;
import com.cheng.work.utils.QueryRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionsServiceImpl extends ServiceImpl<QuestionsMapper, Questions> implements IQuestionsService {

    @Resource
    private QuestionsMapper mapper;

    @Override
    public IPage<Questions> queryList(QueryRequest queryRequest, Questions questions) {
        IPage<Questions> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryList(page, queryRequest, questions);
    }

    @Override
    public IPage<Questions> queryListByPatient(QueryRequest queryRequest, Questions questions, Integer userId) {
        IPage<Questions> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize(), true);
        return mapper.queryListByPatient(page, queryRequest, questions,userId);
    }

}
