<div class="fly-panel fly-column">
    <div class="layui-container">
        <ul class="layui-clear">
            <li class="${ (0 == 0)?string('layui-hide-xs layui-this','')}">
                <a href="/">首页</a>
            </li>
            <#list categories as item>
                <li class="${(0 == 1)?string('layui-hide-xs layui-this','')}">
                    <a href="/">${item.name}</a>
                </li>
            </#list>

            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li>

            <!-- 用户登入后显示 -->
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="user/index.html">我发表的贴</a></li>
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="user/index.html#collection">我收藏的贴</a></li>
        </ul>

        <div class="fly-column-right layui-hide-xs">
            <span class="fly-search"><i class="layui-icon"></i></span>
            <a href="jie/add.html" class="layui-btn">发表新帖</a>
        </div>
        <div class="layui-hide-sm layui-show-xs-block" style="margin-top: -10px; padding-bottom: 10px; text-align: center;">
            <a href="jie/add.html" class="layui-btn">发表新帖</a>
        </div>
    </div>
</div>
