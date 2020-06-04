package com.example.blog.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * Creat by GG
 * Date on 2020/5/6  6:13 下午
 */
@Data
public class Result implements Serializable {
    private String status;
    private String msg;
    private Object data;
    private String action;

    public static Result success() {
        return Result.success("操作成功", null);
    }

    public static Result success(Object data){
        Result e = new Result();
        e.setStatus("0");
        e.setData(data);
        e.setMsg("操作成功");
        return e;
    }
    public static Result success(String mes, Object data){
        Result e = new Result();
        e.setStatus("0");
        e.setData(data);
        e.setMsg(mes);
        return e;
    }
    public static Result error(String mes){
        Result e = new Result();
        e.setStatus(mes);
        e.setData(null);
        e.setMsg("操作失败");
        return e;
    }
    public static Result error(String mes, Object data){
        Result e = new Result();
        e.setStatus("0");
        e.setData(data);
        e.setMsg(mes);
        return e;
    }
    public Result action(String action){
        this.action = action;
        return this;
    }
}
