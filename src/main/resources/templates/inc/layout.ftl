<#-- Layout -->
<#macro layout title>
    <!DOCTYPE html>
    <html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--[if IE]>
        <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'/>
        <![endif]-->

        <title>${title?default('blog')}</title>
        <link rel="stylesheet" href="../res/layui/css/layui.css">
        <link rel="stylesheet" href="../res/css/global.css">
        <script src="../res/layui/layui.js"></script>
        <script src="/res/js/jquery.min.js"></script>

    </head>
    <body>
    <#include "/inc/header.ftl"/>

    <#nested>

    <#include "/inc/footer.ftl"/>
    <script>
        //layui.cache.page = '';
        layui.cache.page = 'user';
        layui.cache.user = {
            username: '${profile.username!"游客"}'
            ,uid: ${profile.id!"-1"}
            ,avatar: '${profile.avatar!"/res/images/avatar/00.jpg"}'
            ,experience: 83
            ,sex: '${profile.sex!"男"}'
        };
        layui.config({
            version: "3.0.0"
            ,base: '/res/mods/'
        }).extend({
            fly: 'index'
        }).use('fly');
    </script>
    </body>
    </html>
</#macro>