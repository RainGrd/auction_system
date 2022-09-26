<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>拍卖品列表页</title>
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
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">拍卖结束的商品</h1>
        <div class="right rulse">当前用户是：<span class="blue strong"><a href="#"
                                                                    title="张三">${sessionScope.sessionUser.userName}</a></span>
        </div>
        <div class="cl"></div>
    </div>
    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="list-wd">成交价</li>
            <li class="borderno">买家</li>
        </ul>
        <c:forEach items="${auctionRecordList}" var="auctionRecord">
            <ul class="rows">
                <li><a href="#" title="">${auctionRecord.auction.auctionName}</a></li>
                <li>${auctionRecord.auction.auctionStartTime}</li>
                <li>${auctionRecord.auction.auctionEndTime}</li>
                <li>${auctionRecord.auction.auctionStartPrice}</li>
                <li class="list-wd">${auctionRecord.auctionPrice}</li>
                <li class="borderno red"><a href="#">${auctionRecord.auctionUser.userName}</a></li>
            </ul>
        </c:forEach>
        <%--      <ul class="rows">
                <li><a href="国书" title="">国书</a></li>
                <li>2010-01-20 12:30:30</li>
                <li>2010-09-08 12:30:30</li>
                <li>2,000</li>
                <li class="list-wd">5,000</li>
                <li class="borderno red"><a href="#">张三</a></li>
              </ul>
              <ul class="rows even">
                <li><a href="国书" title="">瓷器</a></li>
                <li>2010-01-20 12:30:30</li>
                <li>2010-09-08 12:30:30</li>
                <li>2,000</li>
                <li class="list-wd">5,000</li>
                <li class="borderno red"><a href="#">李四</a></li>
              </ul>
              <ul class="rows">
                <li><a href="国书" title="">国画</a></li>
                <li>2010-01-20 12:30:30</li>
                <li>2010-09-08 12:30:30</li>
                <li>2,000</li>
                <li class="list-wd">5,000</li>
                <li class="borderno red"><a href="#">王五</a></li>
              </ul>
              <ul class="rows even border-no">
                <li><a href="国书" title="">电器</a></li>
                <li>2010-01-20 12:30:30</li>
                <li>2010-09-08 12:30:30</li>
                <li>2,000</li>
                <li class="list-wd">5,000</li>
                <li class="borderno red"><a href="#">赵六</a></li>
              </ul>--%>
    </div>
    <h1>拍卖中的商品</h1>
    <div class="items records">
        <ul class="rows even strong rowh">
            <li>名称</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno record">出价记录</li>
            <div class="cl"></div>
        </ul>
        <c:forEach items="${auctionRecordArrayList}" var="auctionRecord">
            <ul class="rows">
                <li><a href="#" title="">${auctionRecord.auction.auctionName}</a></li>
                <li>${auctionRecord.auction.auctionStartTime}</li>
                <li>${auctionRecord.auction.auctionEndTime}</li>
                <li>${auctionRecord.auction.auctionStartPrice}</li>
                <li class="borderno blue record">
                        <%--                    <p>李四 400元</p>
                                            <p>张三 300元</p>
                                            <p>张晶 200元</p>--%>
                    <c:forEach items="${records}" var="obj">
                        <c:if test="${auctionRecord.auction.auctionId==obj.auction.auctionId}">
                            <p>${obj.auctionUser.userName} ${obj.auctionPrice}</p>
                        </c:if>
                    </c:forEach>
                </li>
                <div class="cl"></div>
            </ul>
        </c:forEach>
        <%--        <ul class="rows">
                    <li><a href="国书" title="">国书</a></li>
                    <li>2010-01-20 12:30:30</li>
                    <li>2010-09-08 12:30:30</li>
                    <li>2,000</li>
                    <li class="borderno blue record">
                        <p>李四 400元</p>
                        <p>张三 300元</p>
                        <p>张晶 200元</p>
                    </li>
                    <div class="cl"></div>
                </ul>
                <ul class="rows even">
                    <li><a href="国书" title="">瓷器</a></li>
                    <li>2010-01-20 12:30:30</li>
                    <li>2010-09-08 12:30:30</li>
                    <li>2,000</li>
                    <li class="borderno blue record">
                        <p>李四 400元</p>
                        <p>张三 300元</p>
                        <p>张晶 200元</p>
                    </li>
                    <div class="cl"></div>
                </ul>
                <ul class="rows">
                    <li><a href="国书" title="">国画</a></li>
                    <li>2010-01-20 12:30:30</li>
                    <li>2010-09-08 12:30:30</li>
                    <li>2,000</li>
                    <li class="borderno blue record">
                        <p>李四 300元</p>
                        <p>张三 200元</p>
                        <p>张晶 100元</p>
                    </li>
                    <div class="cl"></div>
                </ul>
                <ul class="rows even border-no">
                    <li><a href="国书" title="">电器</a></li>
                    <li>2010-01-20 12:30:30</li>
                    <li>2010-09-08 12:30:30</li>
                    <li>2,000</li>
                    <li class=" blue record">
                        <p>李四 400元</p>
                        <p>张三 400元</p>
                        <p>张晶 100元</p>
                    </li>
                    <div class="cl"></div>
                </ul>--%>
    </div>
    <!-- main end-->
</div>
</body>
</html>
