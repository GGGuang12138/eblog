package com.example.blog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.service.impl.PostServiceImpl;
import com.example.blog.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
@Controller
public class PostController{

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

    @GetMapping("/category/{id:\\d*}")
    public String category(@PathVariable Long id) {
        Page page = getPage();
        IPage<PostVo> pageData = postService.paging(page,null,id,null,null,"created");
        req.setAttribute("pageData",pageData);
        req.setAttribute("currentCategoryId",id);
        return "post/category";
    }


}
