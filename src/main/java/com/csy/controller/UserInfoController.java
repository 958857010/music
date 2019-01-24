package com.csy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.csy.entity.User;
import com.csy.entity.UserInfo;
import com.csy.service.UserInfoService;
import com.csy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("selectInfoById.do")
    public ResultVo selectUserInfo(int id){

        return userInfoService.selectInfoByid(id);

    }

    @PostMapping("updataUserInfo.do")
    public ResultVo updataUserInfo(UserInfo userInfo){


       return userInfoService.updateUserInfo(userInfo);


    }

}
