package com.example.blog.entity;

import com.example.blog.entity.BaseEntity;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gg
 * @since 2020-05-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 昵称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮件
     */
    private String email;

    /**
     * 手机电话
     */
    private String mobile;

    /**
     * 积分
     */
    private Integer point;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 性别
     */
    private String gender;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * vip等级
     */
    private Integer vipLevel;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 内容数量
     */
    private Integer postCount;

    /**
     * 评论数量
     */
    private Integer commentCount;

    /**
     * 最后的登陆时间
     */
    private Date lasted;


}
