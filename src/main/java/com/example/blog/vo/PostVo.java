package com.example.blog.vo;

import com.example.blog.entity.Post;
import lombok.Data;

/**
 * Creat by GG
 * Date on 2020/5/11  9:26 下午
 */
@Data
public class PostVo extends Post {
    private Long authorId;
    private String authorName;
    private String authorAvatar;
    private Integer authorVip;
    private String categoryName;
}
