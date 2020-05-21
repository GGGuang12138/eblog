package com.example.blog.common.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blog.entity.Category;
import com.example.blog.service.PostService;
import com.example.blog.service.impl.CategoryServiceImpl;
import com.example.blog.service.impl.PostServiceImpl;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * Creat by GG
 * Date on 2020/5/11  10:50 上午
 */
@Component
public class StartConfiguration implements ApplicationRunner, ServletContextAware {

    private ServletContext servletContext;

    @Autowired
    PostServiceImpl postService;
    @Autowired
    CategoryServiceImpl categoryService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 初始化本周热议
        postService.initIndexWeekRank();
        Log.info("ContextStartUp---->加载本周热议");
        // 加载目录
        List<Category> categories = categoryService.list(
                new QueryWrapper<Category>().eq("status",0));
        servletContext.setAttribute("categories", categories);
        //servletContext.setAttribute("currentCategoryId",0);
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
