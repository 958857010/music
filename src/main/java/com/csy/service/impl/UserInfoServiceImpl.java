package com.csy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.csy.dao.UserInfoMapper;

import com.csy.entity.UserInfo;
import com.csy.service.UserInfoService;
import com.csy.utils.ResultUtil;
import com.csy.vo.ResultVo;
import com.csy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shawn
 * @since 2019-01-24
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoDao;

    @Override
    public ResultVo selectInfoByid(int id) {

        UserVO vo = userInfoDao.selectById(id);

        if (vo != null){
            return ResultUtil.execOK(vo);
        }
        return ResultUtil.execERROR();
    }

    @Override
    public ResultVo updateUserInfo(UserInfo userInfo) {

        int i = userInfoDao.updateById(userInfo);
        if (i > 0){

            return ResultUtil.execOK("修改成功");
        }


        return ResultUtil.execOK("修改失败");
    }
}
