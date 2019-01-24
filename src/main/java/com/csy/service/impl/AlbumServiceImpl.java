package com.csy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csy.dao.AlbumMapper;
import com.csy.entity.Album;
import com.csy.service.AlbumService;
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
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {

}
