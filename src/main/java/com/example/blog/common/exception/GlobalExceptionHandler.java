package com.example.blog.common.exception;

import com.example.blog.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Creat by GG
 * Date on 2020/5/6  5:19 下午
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e){
        log.error("------>捕获到全局异常",e);
        if(e instanceof CustomException){

        }

        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("message",e.getMessage());
        modelAndView.addObject("url",req.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public Result jsonErrorHandler(HttpServletRequest request, CustomException e){
        return Result.error(e.getMessage(),"some error data");
    }

}
