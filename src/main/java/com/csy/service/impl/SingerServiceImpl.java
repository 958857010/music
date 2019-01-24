package com.csy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csy.dao.SingerMapper;
import com.csy.entity.Singer;
import com.csy.service.SingerService;
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
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements SingerService {

}
