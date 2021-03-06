package com.csy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.csy.entity.UserInfo;
import com.csy.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shawn
 * @since 2019-01-24
 */
public interface UserInfoService {

     ResultVo selectInfoByid(int id);

     ResultVo updateUserInfo(UserInfo userInfo);

}
