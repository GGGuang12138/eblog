<#include "/inc/layout.ftl"/>
<@layout "博客详情">
    <#include "/inc/header-panel.ftl"/>
    <div class="layui-container">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md8 content detail">
                <div class="fly-panel detail-box">
                    <h1>${post.title}</h1>
                    <div class="fly-detail-info">
                        <!-- <span class="layui-badge">审核中</span> -->
                        <span class="layui-badge layui-bg-green fly-detail-column">${post.categoryName}</span>

<#--                        <span class="layui-badge" style="background-color: #999;">未结</span>-->
                        <!-- <span class="layui-badge" style="background-color: #5FB878;">已结</span> -->
                        <#if post.level gt 0>
                            <span class="layui-badge layui-bg-black">置顶</span>
                        </#if>
                        <#if post.recommend>
                            <span class="layui-badge layui-bg-red">精帖</span>
                        </#if>
<#--                        管理员操作-->
                        <div class="fly-admin-box" data-id="123">
                            <span class="layui-btn layui-btn-xs jie-admin" type="del">删除</span>

                            <span class="layui-btn layui-btn-xs jie-admin" type="set" field="stick" rank="1">置顶</span>
                            <!-- <span class="layui-btn layui-btn-xs jie-admin" type="set" field="stick" rank="0" style="background-color:#ccc;">取消置顶</span> -->

                            <span class="layui-btn layui-btn-xs jie-admin" type="set" field="status" rank="1">加精</span>
                            <!-- <span class="layui-btn layui-btn-xs jie-admin" type="set" field="status" rank="0" style="background-color:#ccc;">取消加精</span> -->
                        </div>
                        <span class="fly-list-nums">
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i>${post.commentCount}</a>
            <i class="iconfont" title="人气">&#xe60b;</i>${post.viewCount}
          </span>
                    </div>
                    <div class="detail-about">
                        <a class="fly-avatar" href="/user/${post.authorId}">
                            <img src="${post.authorAvatar}" alt="${post.authorName}">
                        </a>
                        <div class="fly-detail-user">
                            <a href="../user/home.html" class="fly-link">
                                <cite>${post.authorName}</cite>
                                <i class="iconfont icon-renzheng" title="认证信息：{{ rows.user.approve }}"></i>
                                <#if post.authorVip gt 0>
                                <i class="layui-badge fly-badge-vip">VIP${post.authorVip}</i>
                                </#if>

                            </a>
                            <span>${post.created?string('yyyy-MM-dd')}</span>
                        </div>
                        <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
<#--                            <span style="padding-right: 10px; color: #FF7200">悬赏：60飞吻</span>-->

                            <span class="layui-btn layui-btn-xs jie-admin" type="edit"><a href="add.html">编辑此贴</a></span>
                        </div>
                    </div>
                    <div class="detail-body photos">
                        <p>
                            该模版由 layui官方社区（<a href="http://fly.layui.com/" target="_blank">fly.layui.com</a>）倾情提供，只为表明我们对 layui 执着的信念、以及对未来持续加强的承诺。该模版基于 layui 搭建而成，可作为极简通用型社区的页面支撑。
                        </p>
                        <p>更新日志：</p>
                        <pre>
                        # v3.0 2017-11-30
                        * 采用 layui 2.2.3 作为 UI 支撑
                        * 全面同步最新的 Fly 社区风格，各种细节得到大幅优化
                        * 更友好的响应式适配能力
                        </pre>

                        下载<hr>
                        <p>
                            官网：<a href="http://www.layui.com/template/fly/" target="_blank">http://www.layui.com/template/fly/</a><br>
                            码云：<a href="https://gitee.com/sentsin/fly/" target="_blank">https://gitee.com/sentsin/fly/</a><br>
                            GitHub：<a href="https://github.com/layui/fly" target="_blank">https://github.com/layui/fly</a>
                        </p>
                        封面<hr>
                        <p>
                            <img src="../../res/images/fly.jpg" alt="Fly社区">
                        </p>
                    </div>
                </div>
                <#--            评论区-->
                <div class="fly-panel detail-box" id="flyReply">
                    <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
                        <legend>回帖</legend>
                    </fieldset>
<#--                    评论展示-->
                    <@posts categoryId = 1 pn = 1 size = 1>
                        <ul class="jieda" id="jieda">
                            <#list pageData.records as comment>
                                <li data-id="111" class="jieda-daan">
                                    <a name="item-1111111111"></a>
                                    <div class="detail-about detail-about-reply">
                                        <a class="fly-avatar" href="">
                                            <img src="${comment.authorAvatar}" alt=" ">
                                        </a>
                                        <div class="fly-detail-user">
                                            <a href="" class="fly-link">
                                                <cite>${comment.authorName}</cite>

                                            </a>
                                            <#if comment.authorId == post.authorId>
                                                <span>(楼主)</span>
                                            </#if>
                                            <!--
                                            <span style="color:#5FB878">(管理员)</span>
                                            <span style="color:#FF9E3F">（社区之光）</span>
                                            <span style="color:#999">（该号已被封）</span>
                                            -->
                                        </div>

                                        <div class="detail-hits">
                                            <span>${comment.created?string('yyyy-MM-dd')}</span>
                                        </div>

                                        <i class="iconfont icon-caina" title="最佳答案"></i>
                                    </div>
                                    <div class="detail-body jieda-body photos">
                                        <p>${comment.content}</p>
                                    </div>
                                    <div class="jieda-reply">
                                  <span class="jieda-zan zanok" type="zan">
                                    <i class="iconfont icon-zan"></i>
                                    <em>${comment.voteUp}</em>
                                  </span>
                                        <span type="reply">
                <i class="iconfont icon-svgmoban53"></i>
                回复
              </span>
                                        <div class="jieda-admin">
                                            <span type="edit">编辑</span>
                                            <span type="del">删除</span>
                                            <!-- <span class="jieda-accept" type="accept">采纳</span> -->
                                        </div>
                                    </div>
                                </li>

                            </#list>

                            <!-- 无数据时 -->
                            <!-- <li class="fly-none">消灭零回复</li> -->
                        </ul>
                    </@posts>

<#--                    评论回复-->
                    <div class="layui-form layui-form-pane">
                        <form action="/jie/reply/" method="post">
                            <div class="layui-form-item layui-form-text">
                                <a name="comment"></a>
                                <div class="layui-input-block">
                                    <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <input type="hidden" name="jid" value="123">
                                <button class="layui-btn" lay-filter="*" lay-submit>提交回复</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <#include "/inc/right.ftl"/>
        </div>
    </div>
    <script>
    layui.cache.page = 'jie';

    $(function () {
    layui.use(['fly', 'face'], function() {
    var fly = layui.fly;
    $('.detail-body').each(function(){
    var othis = $(this), html = othis.html();
    othis.html(fly.content(html));
    });
    });
    });

    </script>
</@layout>