package com.csy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csy.entity.User;
import com.csy.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author java1806
 * @since 2019-01-24
 */
public interface UserService {

    //注册
    ResultVo save(User user);

    //校验手机
    ResultVo checkphone(String phone);

    //登陆-前后端分离
    ResultVo login(String phone,String password);

    //退出
    ResultVo loginout(String token);

    //查询主页内容
    ResultVo queryHome(String token);
}
