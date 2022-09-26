<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base id="path" href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改商品页</title>
    <link href="js/plugins/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="js/plugins/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css"
          rel="stylesheet"/>
    <link href="js/plugins/bs_pagination-master/css/jquery.bs_pagination.min.css" type="text/css" rel="stylesheet"/>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/plugins/jquery-1.11.1-min.js"></script>

    <script type="text/javascript" src="js/plugins/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="js/plugins/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript"
            src="js/plugins/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="js/plugins/bs_pagination-master/js/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="js/plugins/bs_pagination-master/localization/en.js"></script>
    <script type="text/javascript" src="js/plugins/ajaxfileupload.js"></script>
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" title="注销">注销</a></div>
    </div>
    <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <dl>
            <dd>
                <label for="auctionName">名称：</label>
                <input type="hidden" id="auctionId" value="${auction.auctionId}">
                <input type="hidden" id="auctionStatus" value="${auction.auctionStatus}">
                <input id="auctionName" type="text" class="inputh lf" value="${auction.auctionName}"/>
                <div class="xzkbg spbg hide lf"></div>
            </dd>
            <dd>
                <label for="auctionStartPrice">起拍价：</label>
                <input id="auctionStartPrice" type="text" class="inputh lf" value="${auction.auctionStartPrice}"/>
                <div class="lf red hide laba">必须为数字</div>
            </dd>
            <dd>
                <label for="auctionUpset">底价：</label>
                <input id="auctionUpset" type="text" class="inputh lf" value="${auction.auctionUpset}"/>
                <div class="lf red hide laba">必须为数字</div>
            </dd>
            <dd>
                <label for="auctionStartTime">开始时间：</label>
                <input id="auctionStartTime" type="text" class="inputh lf" value="${auction.auctionStartTime}"/>
                <div class="lf red hide laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd>
                <label for="auctionEndTime">结束时间：</label>
                <input id="auctionEndTime" type="text" class="inputh lf" value="${auction.auctionEndTime}"/>
                <div class="lf red hide laba">格式：2011-05-05 12:30:00</div>
            </dd>
            <dd class="dds">
                <label for="auctionDesc">描述：</label>
                <textarea id="auctionDesc" name="" cols="" rows="" class="textarea">
                    ${fn:replace(auction.auctionDesc,enter,"<br>")}
                </textarea>
            </dd>
            <dd>
                <label for="pic">修改图片：</label>
                <div id="pic" style="border: 0" class="lf salebd"><a href="#">
                    <img src="${pageContext.request.contextPath}/${auction.auctionPic}${auction.auctionPicType}"
                         width="100" height="100" alt=""/>
                </a></div>
                <input name="picFile" onchange="fileChange()" id="picFile" type="file" class="marg10"/>
                <input type="hidden" id="image_url" value="/${auction.auctionPic}${auction.auctionPicType}">
            </dd>
            <dd class="hegas">
                <input name="" type="button" id="updateAuctionBtn" value="保 存"
                       class="spbg buttombg buttombgs f14 lf buttomb"/>
                <input name="" type="button" id="cancel" value="取 消"  class="spbg buttombg buttombgs f14 lf buttomb"/>

            </dd>
        </dl>
    </div>
    <!-- main end-->
    <!-- footer begin-->

</div>
<!--footer end-->
<script type="text/javascript" src="js/workbench/auction/updateAuction.js"></script>
</body>
</html>
