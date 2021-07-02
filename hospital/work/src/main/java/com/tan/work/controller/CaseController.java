package com.cheng.work.controller;

import com.cheng.work.entity.Case;
import com.cheng.work.entity.Registration;
import com.cheng.work.service.ICaseService;
import com.cheng.work.service.IRegistrationService;
import com.cheng.work.utils.QueryRequest;
import com.cheng.work.utils.ResultVo;
import com.cheng.work.utils.TokenUtil;
import com.cheng.work.utils.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 病例表 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/adminApi/case")
public class CaseController {

    @Autowired
    private ICaseService caseService;

    @Autowired
    private IRegistrationService registrationService;

    @Autowired
    private UserManager userManager;

    /**
     * 开处方
     */
    @PostMapping("/makeCase")
    public ResultVo makeCase(@RequestBody Case entity) {
        Integer id = entity.getId();
        caseService.save(entity);
        // 修改挂号状态
        Registration registration = new Registration();
        registration.setStatus(1);
        registration.setId(id);
        registrationService.updateById(registration);

        return ResultVo.oK();
    }


    /**
     * 管理员或患者查询病例列表
     */
    @GetMapping("/list")
    public ResultVo list(Case entity, QueryRequest queryRequest, HttpServletRequest request) {
        Integer userId = TokenUtil.getAdminUserId(request.getHeader("Authorization"));

        if (userManager.isAdminRole(userId)) {
            return ResultVo.oK(caseService.queryList(entity, queryRequest));
        } else if (userManager.isPatientsRole(userId)) {
            return ResultVo.oK(caseService.queryListByPatient(entity, queryRequest, userId));
        }
        return null;

    }

}
