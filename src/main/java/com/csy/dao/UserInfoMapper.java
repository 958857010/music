package com.csy.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csy.entity.UserInfo;
import com.csy.vo.UserVO;
import org.apache.ibatis.annotations.Select;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shawn
 * @since 2019-01-24
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select ui.*,u.user_ID from user_info ui INNER JOIN user u on u.id=ui.uid where u.id=#{id}")
    UserVO selectById(int id);


}
