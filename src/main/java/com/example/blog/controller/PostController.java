package com.example.blog.controller;


import com.example.blog.common.lang.ErrorJson;
import com.example.blog.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.blog.controller.BaseController;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
@RestController
//@RequestMapping("/post")
public class PostController extends BaseController {
//    @Autowired
//    RedisUtil redisUtil;

//    @ResponseBody
//    @GetMapping("/post/hots")
//    public ErrorJson hotPost(){
//        Set<ZSetOperations.TypedTuple> lastWeekRank = redisUtil.getZSetRank("last_week_rank",0,6);
//
//        List<Map<String,Object>> hotPosts = new ArrayList<>();
//        for (ZSetOperations.TypedTuple typedTuple:lastWeekRank){
//            Map<String,Object> map = new HashMap<>();
//            map.put("comment_count",typedTuple.getScore());
//            map.put("id",redisUtil.hget("rank_post_"+typedTuple.getValue(),"post:id"));
//            map.put("title",redisUtil.hget("rank_post_" + typedTuple.getValue(),"post:title"));
//
//            hotPosts.add(map);
//        }
//        return ErrorJson.success(hotPosts);
//    }

}
