package com.example.blog.service.impl;

import com.example.blog.entity.UserCollection;
import com.example.blog.mapper.UserCollectionMapper;
import com.example.blog.service.UserCollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
@Service
public class UserCollectionServiceImpl extends ServiceImpl<UserCollectionMapper, UserCollection> implements UserCollectionService {

}
