package com.example.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Creat by GG
 * Date on 2020/5/5  4:33 下午
 */
@Controller
public class IndexController{

    @Autowired
    HttpServletRequest req;

    @Autowired
    PostServiceImpl postService;

    public Page getPage(){
        int pn = ServletRequestUtils.getIntParameter(req,"pn",1);
        int size = ServletRequestUtils.getIntParameter(req,"size",2);
        Page page = new Page(pn, size);
        return page;
    }

    @RequestMapping({"", "/", "/index"})
    public String index () {
        IPage results = postService.paging(getPage(),null,null,null,null,"created");
        req.setAttribute("pageData",results);
        req.setAttribute("currentCategoryId",0);
        return "index";
    }

}
