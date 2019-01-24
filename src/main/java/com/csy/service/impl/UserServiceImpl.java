package com.csy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csy.constant.SystemConst;
import com.csy.entity.User;
import com.csy.dao.UserMapper;
import com.csy.service.UserService;
import com.csy.utils.JedisUtil;
import com.csy.utils.ResultUtil;
import com.csy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author java1806
 * @since 2019-01-24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisUtil jedisUtil;

    //注册
    @Override
    public ResultVo save(User user) {
        return ResultUtil.exec(userMapper.insert(user),user);
    }

    //检查手机号
    @Override
    public ResultVo checkphone(String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        User user = userMapper.selectOne(queryWrapper);
        if (user!=null){
            return ResultUtil.execERROR();
        }else {
            return ResultUtil.execOK();
        }
    }

    //登陆
    @Override
    public ResultVo login(String phone, String password) {
        return null;
    }

    //登出
    @Override
    public ResultVo loginout(String token) {
        if (jedisUtil.checkFiled(SystemConst.TOKENMAP,"user:"+token)){
            jedisUtil.del(SystemConst.TOKENMAP,"user:"+token);
        }
        return ResultUtil.execOK();
    }

    //查看主页
    @Override
    public ResultVo queryHome(String token) {
        return null;
    }
}
