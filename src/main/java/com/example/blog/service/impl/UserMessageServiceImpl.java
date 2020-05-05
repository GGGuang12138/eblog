package com.example.blog.service.impl;

import com.example.blog.entity.UserMessage;
import com.example.blog.mapper.UserMessageMapper;
import com.example.blog.service.UserMessageService;
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
public class UserMessageServiceImpl extends ServiceImpl<UserMessageMapper, UserMessage> implements UserMessageService {

}
