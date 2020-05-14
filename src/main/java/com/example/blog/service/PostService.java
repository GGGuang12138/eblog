package com.example.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.vo.PostVo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
public interface PostService extends IService<Post> {

    IPage<PostVo> paging(Page page, Long userId, Long categoryId, Integer level, Integer recommend, String order);
}
