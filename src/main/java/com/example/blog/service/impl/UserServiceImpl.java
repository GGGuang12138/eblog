package com.example.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blog.common.shiro.AccountDTO;
import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public AccountDTO login(String email,String password) {
        User user = this.getOne(new QueryWrapper<User>().eq("email",email));
        if (user == null) {
            throw  new UnknownAccountException();
        }
        if (!user.getPassword().equals(password)) {
            throw  new IncorrectCredentialsException();
        }
        // 更新登陆时间
        user.setLasted(new Date());
        this.updateById(user);

        AccountDTO accountDTO = new AccountDTO();
        BeanUtil.copyProperties(user,accountDTO);
        return accountDTO;
    }

}
