package com.example.blog.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blog.common.util.RedisUtil;
import com.example.blog.entity.Post;
import com.example.blog.mapper.PostMapper;
import com.example.blog.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    RedisUtil redisUtil;


    // 初始化最近七天文章数据
    public void initIndexWeekRank(){
        //mybatis plus条件构造器 wrapper（不可用于传输）
        List<Post> last7DayPosts = this.list(new QueryWrapper<Post>()
                .ge("created", DateUtil.offsetDay(new Date(),-7).toJdkDate())
                .select("id,title,user_id,comment_count,view_count,created"));
        for(Post post:last7DayPosts){
            // "每天数据集合 day_rank:yyyyMMdd"
            String key = "day_rank:" + DateUtil.format(post.getCreated(), DatePattern.PURE_DATE_FORMAT);
            // 计算有效时间
            long between = DateUtil.between(new Date(),post.getCreated(), DateUnit.DAY);
            long expireTime = (7-between)*24*60*60;
            //将文章缓存到set中，评论数量作为标准
            redisUtil.zSet(key,post.getId(),post.getCommentCount());
            redisUtil.expire(key,expireTime);
            //缓存文章基本信息（hash结构)
            this.hashCachePostIdAndTitle(post);
        }
        //七天评论数相加
        this.zUnionAndStoreLeast7DaysWeekRank();
    }

    /**
     * 哈希结构缓存文章标题和id
     * @param post
     */
    private void hashCachePostIdAndTitle(Post post){
        //redisUtil.del("rank_post_"+post.getId());
        boolean isExist = redisUtil.hasKey("rank_post_"+post.getId());
        if(!isExist){
            long between = DateUtil.between(new Date(),post.getCreated(), DateUnit.DAY);
            long expireTime = (7-between)*24*60*60;
            redisUtil.hset("rank_post_"+post.getId(),"post:id",post.getId());
            redisUtil.hset("rank_post_"+post.getId(),"post:title",post.getTitle());
        }
    }

    /**
     * 统计7天内每天评论数量的交集
     */
    public void zUnionAndStoreLeast7DaysWeekRank(){
        List<String> keys = new ArrayList<>();
        String key = "day_rank:"+ DateUtil.format(new Date(),DatePattern.PURE_DATE_PATTERN);
        for(int i =-7;i<0;i++){
            Date date = DateUtil.offsetDay(new Date(),i).toJdkDate();
            keys.add("day_rank:"+ DateUtil.format(date,DatePattern.PURE_DATE_PATTERN));
        }
        redisUtil.zUnionAndStore(key,keys,"last_week_rank");
    }
}
