<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>竞拍者注册页面</title>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script src="js/plugins/jquery-1.11.1-min.js"></script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="zclf login logns">
        <h1 class="blue">用户注册</h1>
        <dl>
            <dd>
                <label for="userName"> <small>*</small>用户名</label>
                <input id="userName" type="text" class="inputh lf" value=""/>
                <div class="lf hide red laba">用户名要求不低于6个字符</div>
            </dd>
            <dd>
                <label for="userPwd"> <small>*</small>密码</label>
                <input id="userPwd" type="password" class="inputh lf" value=""/>
                <div class="lf hide red laba">密码要求不低于6个字符</div>
            </dd>
            <dd>
                <label for="cardNo"> <small>*</small>身份证号</label>
                <input id="cardNo" type="text" class="inputh lf" value=""/>
                <div class="lf hide red laba">身份证号必填</div>
            </dd>
            <dd>
                <label for="tel"> <small>*</small>电话</label>
                <input id="tel" type="text" class="inputh lf" value=""/>
                <div class="lf hide red laba">电话号码必填</div>
            </dd>
            <dd>
                <label for="address"> <small>*</small>住址</label>
                <input id="address" type="text" class="inputh lf" value=""/>
            </dd>
            <dd>
                <label for="emailNumber"> <small>*</small>邮政编码</label>
                <input id="emailNumber" type="text" class="inputh lf" value=""/>
            </dd>
            <dd class="hegas">
                <label for="imgVerify"> <small>*</small>验证码</label>
                <input id="imgVerify" type="text" class="inputh inputs lf" value=""/>
                <span class="wordp lf"><img id="checkCode" src="" width="96" height="35"
                                            alt=""/></span>
                <span class="blues lf"><a id="checkCodeSwitch" href="javascript:getVerify()" title="">看不清</a></span>
            </dd>
            <dd class="hegas">
                <input name="" type="checkbox" id="rem_u"/>
                <label for="rem_u" class="labels">我同意<span class="blues">《服务条款》</span></label>
            </dd>
            <dd class="hegas">
                <label>&nbsp;</label>
                <input name="" id="registerBtn" type="button" value="立即注册" class="spbg buttombg buttombgs f14 lf"/>
            </dd>
        </dl>
    </div>
    <!-- main end-->
    <!-- footer begin-->
</div>
<!--footer end-->
<script type="text/javascript" src="js/settings/qx/user/biddersRegister.js">
</script>
</body>
</html>
