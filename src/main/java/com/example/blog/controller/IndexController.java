package com.example.blog.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.common.lang.Result;
import com.example.blog.service.impl.PostServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Creat by GG
 * Date on 2020/5/5  4:33 下午
 */
@Controller
public class IndexController {

    @Autowired
    HttpServletRequest req;

    @Autowired
    PostServiceImpl postService;

    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 2);
        Page page = new Page(pn, size);
        return page;
    }

    @RequestMapping({"", "/", "/index"})
    public String index() {
        IPage results = postService.paging(getPage(), null, null, null, null, "created");
        req.setAttribute("pageData", results);
        req.setAttribute("currentCategoryId", 0);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public Result doLogin(String email, String password){
        if (StrUtil.isEmpty(email) || StrUtil.isEmpty(password)){
            return Result.error("用户名或密码不能为空");
        }
        //加密
        UsernamePasswordToken token = new UsernamePasswordToken(email, SecureUtil.md5(password));
        try{
            // 获取当前登陆用户将他交给realm进行逻辑管理
            SecurityUtils.getSubject().login(token);
        }catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                return Result.error("用户不存在");
            } else if (e instanceof LockedAccountException) {
                return Result.error("用户被禁用");
            } else if (e instanceof IncorrectCredentialsException) {
                return Result.error("密码错误");
            } else {
                return Result.error("用户认证失败");
            }
        }
        return Result.success().action("/");

    }
}