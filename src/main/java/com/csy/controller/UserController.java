package com.csy.controller;

import com.csy.entity.User;
import com.csy.service.UserService;
import com.csy.utils.Message;
import com.csy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //查询手机号是否可用
    @GetMapping("checkphone.do")
    public ResultVo checkphone(String phone){
        return userService.checkphone(phone);
    }

    //注册用户
    @PostMapping("usersave.do")
    public ResultVo save(User user){
        return userService.save(user);
    }

    //注销
    @GetMapping("loginout.do")
    public ResultVo loginout(String token){
        return userService.loginout(token);
    }


}
