package com.csy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csy.dao.SongsMapper;
import com.csy.entity.Songs;
import com.csy.service.SongsService;
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
public class SongsServiceImpl extends ServiceImpl<SongsMapper, Songs> implements SongsService {

}
