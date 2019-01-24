package com.csy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.csy.dao.UserInfoMapper;
import com.csy.entity.UserInfo;
import com.csy.service.UserInfoService;
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

}
