package com.example.blog.common.exception;

/**
 * Creat by GG
 * Date on 2020/5/6  12:21 下午
 */
public class CustomException extends RuntimeException {
    private int code;

    public CustomException(int code){
        this.code=code;
    }
    public CustomException(String message) {
        super(message);
    }

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }
}
