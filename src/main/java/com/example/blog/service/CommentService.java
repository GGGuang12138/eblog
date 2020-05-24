package com.example.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.vo.CommentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
public interface CommentService extends IService<Comment> {
    IPage<CommentVo> paging(Page page, Long postId, Long userId, String order);

}
