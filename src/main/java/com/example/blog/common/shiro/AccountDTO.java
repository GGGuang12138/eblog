package com.example.blog.common.shiro;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Creat by GG
 * Date on 2020/6/1  10:33 上午
 */
@Data
public class AccountDTO implements Serializable {
    private  Long id;


    private String username;
    private String password;


    private String email;
    private String sign;

    private String avatar;
    private String gender;
    private Date created;

    public  String getSex() {
        return "0".equals (gender)? "女":"男";
    }
}
