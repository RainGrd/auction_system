<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base id="path" href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>竞拍页</title>
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
    <div class="items sg-font lf">
        <ul class="rows">
            <li id="auctionId" class="hide">${auction.auctionId}</li>
            <li>名称：</li>
            <li class="borderno">${auction.auctionName}</li>
        </ul>
        <ul class="rows">
            <li>描述：</li>
            <li class="borderno">${auction.auctionDesc}</li>
        </ul>
        <ul class="rows">
            <li>开始时间：</li>
            <li class="borderno">${auction.auctionStartTime}</li>
        </ul>
        <ul class="rows">
            <li>结束时间：</li>
            <li class="borderno">${auction.auctionEndTime}</li>
        </ul>
        <ul class="rows border-no">
            <li>起拍价：</li>
            <li id="auctionStartPrice" class="borderno">${auction.auctionStartPrice}</li>
        </ul>
    </div>
    <div class="rg borders"><img src="${pageContext.request.contextPath}/${auction.auctionPic}${auction.auctionPicType}"
                                 width="270" height="185" alt=""/>
    </div>
    <div class="cl"></div>
    <div class="top10 salebd">
        <p>
            <label for="sale">出价：</label>
            <input type="text" class="inputwd" id="sale" value=""/>
            <input name="" type="button" value="竞 拍" id="auctionBtn" class="spbg buttombg f14  sale-buttom"/>
        </p>
        <p id="auctionPrice" class="f14 hide red">不能低于最高竞拍价</p>
    </div>
    <div class="top10">
        <input name="" type="button" value="刷 新" id="refreshBtn" class="spbg buttombg f14"/>
        <input name="" type="button" id="returnsListBtn" value="返回列表" class="spbg buttombg f14"/>
    </div>
    <div class="offer">
        <h3>出价记录</h3>
        <div class="items sg-font">
            <ul class="rows even strong">
                <li>竞拍时间</li>
                <li>竞拍价格</li>
                <li class="borderno">竞拍人</li>
            </ul>
            <%--            <ul class="rows">
                            <li>2010-01-05 12:50:01</li>
                            <li>50000,00</li>
                            <li class="borderno">张三</li>
                        </ul>
                        <ul class="rows even">
                            <li>2010-01-05 11:50:01</li>
                            <li>40000,00</li>
                            <li class="borderno">李四</li>
                        </ul>
                        <ul class="rows">
                            <li>2010-01-05 10:50:01</li>
                            <li>30000,00</li>
                            <li class="borderno">王五</li>
                        </ul>
                        <ul class="rows even border-no">
                            <li>2010-01-05 09:50:01</li>
                            <li>20000,00</li>
                            <li class="borderno">李靖</li>
                        </ul>--%>
            <c:forEach items="${auctionRecords}" var="auctionRecord">
                <ul class="rows">
                    <li>${auctionRecord.auctionTime}</li>
                    <li>${auctionRecord.auctionPrice}</li>
                    <li class="borderno">
                        ${auctionRecord.auctionUser.userName}
<%--                        <c:forEach items="${auctionRecord.auctionUsers}" var="auctionUser">
                            ${auctionUser.userName}
                        </c:forEach>--%>
                    </li>
                </ul>
            </c:forEach>
        </div>
    </div>
    <!-- main end-->
</div>
<script type="text/javascript" src="js/workbench/auction/auction.js"></script>
</body>
</html>
