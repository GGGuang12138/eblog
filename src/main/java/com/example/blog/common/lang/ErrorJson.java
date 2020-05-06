package com.example.blog.common.lang;

import lombok.Data;

/**
 * Creat by GG
 * Date on 2020/5/6  6:13 下午
 */
@Data
public class ErrorJson {
    private String code;
    private String msg;
    private Object data;

    public static ErrorJson success(Object data){
        ErrorJson e = new ErrorJson();
        e.setCode("0");
        e.setData(data);
        e.setMsg("操作成功");
        return e;
    }
    public static ErrorJson success(String mes,Object data){
        ErrorJson e = new ErrorJson();
        e.setCode("0");
        e.setData(data);
        e.setMsg(mes);
        return e;
    }
    public static ErrorJson error(String mes){
        ErrorJson e = new ErrorJson();
        e.setCode(mes);
        e.setData(null);
        e.setMsg("操作失败");
        return e;
    }
    public static ErrorJson error(String mes,Object data){
        ErrorJson e = new ErrorJson();
        e.setCode("0");
        e.setData(data);
        e.setMsg(mes);
        return e;
    }
}
