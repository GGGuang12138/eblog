package com.example.blog.common.config;

import com.example.blog.template.HotsTemplate;
import com.example.blog.template.PostsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Creat by GG
 * Date on 2020/5/11  6:47 下午
 */

@Configuration
public class FreemarkerConfiguration {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void setUp(){
        configuration.setSharedVariable("hots",applicationContext.getBean(HotsTemplate.class));
        configuration.setSharedVariable("posts",applicationContext.getBean(PostsTemplate.class));
    }
}
