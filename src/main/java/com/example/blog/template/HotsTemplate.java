package com.example.blog.template;

import com.example.blog.common.template.DirectiveHandler;
import com.example.blog.common.template.TemplateDirective;
import com.example.blog.common.util.RedisUtil;
import com.example.blog.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Creat by GG
 * Date on 2020/5/11  6:26 下午
 */
@Component
public class HotsTemplate extends TemplateDirective {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String getName() {
        return "hots";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {

        Set<ZSetOperations.TypedTuple> lastWeekRank = redisUtil.getZSetRank("last_week_rank",0,6);

        List<Map<String,Object>> hotPosts = new ArrayList<>();
        for (ZSetOperations.TypedTuple typedTuple:lastWeekRank){
            Map<String,Object> map = new HashMap<>();
            map.put("comment_count",typedTuple.getScore());
            map.put("id",redisUtil.hget("rank_post_"+typedTuple.getValue(),"post:id"));
            map.put("title",redisUtil.hget("rank_post_" + typedTuple.getValue(),"post:title"));

            hotPosts.add(map);
        }
        handler.put(RESULTS,hotPosts).render();
    }
}
