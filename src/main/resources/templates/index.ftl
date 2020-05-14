<#include "/inc/layout.ftl"/>

<@layout "首页">
    <#include "/inc/header-panel.ftl"/>
    <div class="layui-container">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md8">
<#--                置顶-->
                <div class="fly-panel">
                    <div class="fly-panel-title fly-filter">
                        <a>置顶</a>
                        <a href="#signin" class="layui-hide-sm layui-show-xs-block fly-right" id="LAY_goSignin" style="color: #FF5722;">去签到</a>
                    </div>
<#--                    置顶文章列表-->
                    <@posts pn =1 size = 5 categoryId =1>
                        <ul class="fly-list">
                            <#list results.records as post >
                                <li>
                                    <a href="user/home.html" class="fly-avatar">
                                        <img src="${post.authorAvatar}" alt="${post.authorName}">
                                    </a>
                                    <h2>
                                        <a class="layui-badge">${post.categoryName}</a>
                                        <a href="jie/detail.html">${post.title}</a>
                                    </h2>
                                    <div class="fly-list-info">
                                        <a href="user/home.html" link>
                                            <cite>${post.authorName}</cite>
                                            <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                            <#if post.authorVip gt 0>
                                                <i class="layui-badge fly-badge-vip">VIP${post.authorVip}</i>
                                            </#if>
                                        </a>
                                        <span>${post.created?string('yyyy-MM-dd')}</span>

<#--                                        span<span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>-->
<#--                                        <span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                        <span class="fly-list-nums">
                                            <i class="iconfont icon-pinglun1" title="回答"></i>${post.commentCount}
                                        </span>
                                    </div>
                                    <div class="fly-list-badge">
                                        <!--
                                        <span class="layui-badge layui-bg-black">置顶</span>
                                        <span class="layui-badge layui-bg-red">精帖</span>
                                        -->
                                    </div>
                                </li>
                            </#list>
                        </ul>
                    </@posts>

                </div>
<#--                分类-->
                <div class="fly-panel" style="margin-bottom: 0;">
<#--                    文章分类-->
                    <div class="fly-panel-title fly-filter">
                        <a href="" class="layui-this">综合</a>
                        <span class="fly-mid"></span>
                        <a href="">未结</a>
                        <span class="fly-mid"></span>
                        <a href="">已结</a>
                        <span class="fly-mid"></span>
                        <a href="">精华</a>
                        <span class="fly-filter-right layui-hide-xs">
                            <a href="" class="layui-this">按最新</a>
                            <span class="fly-mid"></span>
                            <a href="">按热议</a>
                        </span>
                    </div>
<#--                    分类文章列表-->
                    <ul class="fly-list">
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">分享</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--<i class="iconfont icon-renzheng" title="认证信息：XXX"></i>-->
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <span class="layui-badge layui-bg-red">精帖</span>
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" alt="贤心">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="jie/detail.html">基于 layui 的极简社区页面模版</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                    <cite>贤心</cite>
                                    <!--
                                    <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                    <i class="layui-badge fly-badge-vip">VIP3</i>
                                    -->
                                </a>
                                <span>刚刚</span>

                                <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66
              </span>
                            </div>
                            <div class="fly-list-badge">
                                <!--<span class="layui-badge layui-bg-red">精帖</span>-->
                            </div>
                        </li>
                    </ul>
<#--                    更多按钮-->
                    <div style="text-align: center">
                        <div class="laypage-main">
                            <a href="jie/index.html" class="laypage-next">更多求解</a>
                        </div>
                    </div>

                </div>
            </div>
            <#include "/inc/right.ftl"/>
        </div>
    </div>
</@layout>