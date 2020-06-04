package com.example.blog.common.shiro;

import com.example.blog.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Creat by GG
 * Date on 2020/5/30  12:02 下午
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;


        AccountDTO accountDTO = userService.login(usernamePasswordToken.getUsername(),String.valueOf(usernamePasswordToken.getPassword()));
        SecurityUtils.getSubject().getSession().setAttribute("profile",accountDTO);
        //根据数据库查询结构返回认证是否成功
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(accountDTO,authenticationToken.getCredentials(),getName());
        //根据查询到的密码跟token的进行比较，发现不对
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("",accountDTO.getPassword(),"");
        return info;
    }
}
