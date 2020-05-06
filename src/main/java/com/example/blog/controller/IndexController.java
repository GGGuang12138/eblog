package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Creat by GG
 * Date on 2020/5/5  4:33 下午
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String index () {
        return "index";
    }
}
