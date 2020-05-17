package com.example.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Creat by GG
 * Date on 2020/5/5  10:51 上午
 */
public class BaseController {
    @Autowired
    HttpServletRequest req;


}
