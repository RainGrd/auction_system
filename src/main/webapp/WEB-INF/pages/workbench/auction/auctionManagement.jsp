<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>商品管理页</title>
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
        <h1 class="lf">在线拍卖系统</h1>
        <div class="logout right"><a href="#" id="exit" title="注销">注销</a></div>
    </div>
    <div class="forms">
        <label for="name">名称</label>
        <input name="" type="text" class="nwinput" id="name"/>
        <label for="auctionDesc">描述</label>
        <input name="" type="text" id="auctionDesc" class="nwinput"/>
        <label for="auctionStartTime">开始时间</label>
        <input name="" type="text" id="auctionStartTime" class="nwinput"/>
        <label for="auctionEndTime">结束时间</label>
        <input name="" type="text" id="auctionEndTime" class="nwinput"/>
        <label for="auctionStartPrice">起拍价</label>
        <input name="" type="text" id="auctionStartPrice" class="nwinput"/>
        <input name="" type="button" id="queryAuctionBtn" value="查询" class="spbg buttombg f14  sale-buttom"/>
        <input type="button" id="insertAuctionBtn" value="发布" class="spbg buttombg f14  sale-buttom buttomb"/>
    </div>
    <div id="items" class="items">
      <%--  <ul class="rows even strong">
            <li>名称</li>
            <li class="list-wd">描述</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno">操作</li>
        </ul>
        <ul class="rows">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍" onclick="dele();">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows even">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows even">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows even">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows even">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>
        <ul class="rows even">
            <li><a href="国书" title="">国书</a></li>
            <li class="list-wd">明国藏书</li>
            <li>2010-01-20 12:30:30</li>
            <li>2010-09-08 12:30:30</li>
            <li>2,000</li>
            <li class="borderno red">
                <a href="#" title="竞拍">修改</a>|
                <a href="#" title="竞拍" onclick="abc();">删除</a>
            </li>
        </ul>--%>
    </div>
    <div id="page" class="page">
<%--        <a href="#" title="">首页</a>
        <a href="#" title="">上一页</a>
        <span class="red">前5页</span>
        <a href="#" title="">1</a>
        <a href="#" title="">2</a>
        <a href="#" title="">3</a>
        <a href="#" title="">4</a>
        <a href="#" title="">5</a>
        <a href="#" title="">下一页</a>
        <a href="#" title="">尾页</a>--%>
    </div>
    <!-- main end-->
    <script src="js/workbench/auction/auctionManagement.js"></script>
</div>
</body>
</html>
