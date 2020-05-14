package com.example.blog.template;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.common.template.DirectiveHandler;
import com.example.blog.common.template.TemplateDirective;
import com.example.blog.service.PostService;
import com.example.blog.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Creat by GG
 * Date on 2020/5/11  8:24 下午
 */
@Component
public class PostsTemplate extends TemplateDirective {

    @Autowired
    PostServiceImpl postService;

    @Override
    public String getName() {
        return "posts";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {
        //从界面获取值
        //分页信息
        int pn = handler.getInteger("pn",1);
        int size = handler.getInteger("size",5);
        //列表
        Long categoryId = handler.getLong("categoryId",1);
        String order = handler.getString("order","created");//mybatis plus实现分页
        Page page = new Page(pn,size);
        IPage results = postService.paging(page,1L,categoryId,1,1,order);
        handler.put(RESULTS,results).render();
    }
}
