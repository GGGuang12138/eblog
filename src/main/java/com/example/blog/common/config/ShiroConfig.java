package com.example.blog.common.config;

import com.example.blog.common.shiro.AccountRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creat by GG
 * Date on 2020/5/30  10:53 上午
 */
@Slf4j
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setLoginUrl("/login");
        filterFactoryBean.setSuccessUrl("/index");
        filterFactoryBean.setUnauthorizedUrl("/error");
        //设置过滤器


        return filterFactoryBean;
    }



    @Bean
    public SecurityManager securityManager(AccountRealm accountRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(accountRealm);
        return securityManager;
    }
}
