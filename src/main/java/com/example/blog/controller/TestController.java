package com.example.blog.controller;

import com.example.blog.common.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Creat by GG
 * Date on 2020/5/6  9:27 下午
 */
@Controller
public class TestController {
    @RequestMapping("/text")
    public String test() throws CustomException{
        throw new CustomException("SERVER BOOM!");
    }
}
