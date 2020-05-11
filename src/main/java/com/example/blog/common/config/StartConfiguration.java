package com.example.blog.common.config;

import com.example.blog.service.PostService;
import com.example.blog.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 * Creat by GG
 * Date on 2020/5/11  10:50 上午
 */
@Component
public class StartConfiguration implements ApplicationRunner, ServletConfigAware {

    private ServletContext servletContext;

    @Autowired
    PostServiceImpl postServiceImpl;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        postServiceImpl.initIndexWeekRank();
    }

    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        this.servletContext=servletContext;
    }
}
