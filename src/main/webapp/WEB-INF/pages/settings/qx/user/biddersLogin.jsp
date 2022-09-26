<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户登录</title>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script src="js/plugins/jquery-1.11.1-min.js"></script>
    <script src="js/plugins/jquery.cookie.js"></script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="main">
        <div class="sidebar">
            <p><img src="images/img1.jpg" width="443" height="314" alt=""/></p>
        </div>
        <div class="sidebarg">
            <form action="" method="post" target='_blank'>
                <div class="login">
                    <dl>
                        <dt class="blues">用户登陆</dt>
                        <dd><label for="name">用户名：</label><input type="text" class="inputh"
                                                                 value="${cookie.username.value}"
                                                                 id="name"/>
                        </dd>
                        <dd><label for="password">密 码：</label><input type="password" class="inputh"
                                                                     value="${cookie.password.value}"
                                                                     id="password"/></dd>
                        <dd>
                            <label class="lf" for="passwords">验证码：</label>
                            <input type="text" class="inputh inputs lf" value="${cookie.code.value}" id="passwords"/>
                            <span class="wordp lf"><img id="imgVerify" src="" width="96" height="35" alt=""/></span>
                            <span class="blues lf"><a id="checkCodeSwitch" href="javascript:getVerify()"
                                                      title="">看不清</a></span>
                        </dd>
                        <dd>
                            <c:if test="${not empty cookie.username and not empty cookie.password}">
                                <input name="" type="checkbox" id="idRemPwd" checked="checked"/>下次自动登录
                            </c:if>
                            <c:if test="${empty cookie.username or empty cookie.password}">
                                <input name="" type="checkbox" id="idRemPwd"/>下次自动登录
                            </c:if>
                        </dd>
                        <dd class="buttom">
                            <input name="" type="button" id="loginBtn" value="登 录" class="spbg buttombg f14 lf"/>
                            <input name="" id="register" type="button" value="注 册" class="spbg buttombg f14 lf"/>
                            <span class="blues  lf"><a href="" title="">忘记密码?</a></span>
                            <div class="cl"></div>
                        </dd>

                    </dl>
                </div>
            </form>
        </div>
        <div class="cl"></div>
    </div>
    <!-- main end-->

    <!-- footer begin-->
</div>
<!--footer end-->
<script type="text/javascript" src="js/settings/qx/user/biddersLogin.js">

</script>
</body>
</html>
