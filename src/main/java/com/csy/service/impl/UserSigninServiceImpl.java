package com.csy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csy.dao.UserSigninMapper;
import com.csy.entity.UserSignin;
import com.csy.service.UserSigninService;
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
public class UserSigninServiceImpl extends ServiceImpl<UserSigninMapper, UserSignin> implements UserSigninService {

}
