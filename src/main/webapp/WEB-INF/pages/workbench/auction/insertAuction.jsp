<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%--导入JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <base id="path" href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新增商品页</title>
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
        <form enctype="multipart/form-data" method="post" id="insertForm">
            <dl>
                <dd>
                    <label for="name">名称：</label>
                    <input type="text" id="name" class="inputh lf" value=""/>
                    <div class="xzkbg hide spbg lf"></div>
                </dd>
                <dd>
                    <label for="startPrice">起拍价：</label>
                    <input type="text" id="startPrice" class="inputh lf" value=""/>
                    <div class="lf hide red laba">必须为数字</div>
                </dd>
                <dd>
                    <label for="endPrice">底价：</label>
                    <input type="text" id="endPrice" class="inputh lf" value=""/>
                    <div class="lf hide red laba">必须为数字</div>
                </dd>
                <dd>
                    <label for="startDate">开始时间：</label>
                    <input type="text" id="startDate" class="inputh lf" value=""/>
                    <div class="lf hide red laba">格式：2010-05-05 12:30:00</div>
                </dd>
                <dd>
                    <label for="endDate">结束时间：</label>
                    <input type="text" id="endDate" class="inputh lf" value=""/>
                    <div class="lf hide red laba">格式：2010-05-06 16:30:00</div>
                </dd>
                <dd class="dds">
                    <label for="picFile">拍卖品图片：</label>
                    <div id="pic" class="lf salebd" style="border: 0">
                        <%--<a href="#"><img   src="" width="100" height="100" alt=""/></a>--%>
                    </div>
                    <input id="picFile" onchange="fileChange()" name="picFile" type="file" class="offset10 lf"/>
                    <input type="hidden" id="image_url">
                </dd>
                <dd class="dds">
                    <label for="description">描述：</label>
                    <textarea id="description" name="" cols="" rows="" class="textarea"></textarea>
                </dd>
                <dd class="hegas">
                    <input name="" type="button" id="saveAuctionBtn" value="保 存"
                           class="spbg buttombg buttombgs buttomb f14 lf"/>
                    <input name="" type="button"  id="cancel" value="取 消"
                           class="spbg buttombg buttombgs buttomb f14 lf"/>
                </dd>
            </dl>
        </form>
    </div>
    <!-- main end-->
    <!-- footer begin-->
</div>
<!--footer end-->
<script src="js/workbench/auction/insertAuction.js"></script>
</body>
</html>
