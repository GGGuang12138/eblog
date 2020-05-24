package com.example.blog.vo;

import com.example.blog.entity.Comment;
import lombok.Data;

/**
 * Creat by GG
 * Date on 2020/5/23  5:19 下午
 */
@Data
public class CommentVo extends Comment {
    private Long authorId;
    private String authorName;
    private String authorAvatar;
}
