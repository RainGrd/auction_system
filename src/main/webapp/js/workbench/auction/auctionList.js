$(function () {
    /**
     * 登录退出方式
     */
    $('#exit').on('click', function () {
        /*发送退出请求*/
        window.location.href = 'settings/qx/user/loginExit.do';
    });
    queryAuctionByConditionForPage(1, 5);

    /**
     * 查询按钮点击事件
     */
    $('#queryAuctionBtn').on('click', function () {
        queryAuctionByConditionForPage(1, $('#page').bs_pagination("getOption", "rowsPerPage"))
    })
})

/**
 * 分页查询函数
 */
function queryAuctionByConditionForPage(pageNum, pageSize) {
    /*收集参数*/
    let auctionName = $('#name').val();
    let auctionDesc = $('#auctionDesc').val();
    let auctionStartTime = $('#auctionStartTime').val();
    let auctionEndTime = $('#auctionEndTime').val();
    let auctionStartPrice = $('#auctionStartPrice').val();
    /*发送Ajax请求*/
    $.ajax({
        url: 'workbench/auction/queryAuctionByConditionForPage.do',
        type: 'post',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify({
            auctionName: auctionName,
            auctionDesc: auctionDesc,
            auctionStartTime: auctionStartTime,
            auctionEndTime: auctionEndTime,
            auctionStartPrice: auctionStartPrice,
            pageNum: 1,
            pageSize: 5,
        }),
        success: function (result) {
            console.log(result);
            let htmlStr = '<ul class="rows even strong">\n' +
                '            <li>名称</li>\n' +
                '            <li class="list-wd">描述</li>\n' +
                '            <li>开始时间</li>\n' +
                '            <li>结束时间</li>\n' +
                '            <li>起拍价</li>\n' +
                '            <li class="borderno">操作</li>\n' +
                '        </ul>';
            $.each(result.list, function (index, obj) {
                if (index % 2 === 0) {
                    htmlStr += '<ul class="rows">\n' +
                        '<li><a href="workbench/auction/toAuctionResults.do?auctionId=' + obj.auctionId + '" title="">' + obj.auctionName + '</a></li>\n' +
                        '<li class="list-wd">' + obj.auctionDesc + '</li>\n' +
                        '<li>' + obj.auctionStartTime + '</li>\n' +
                        '<li>' + obj.auctionEndTime + '</li>\n' +
                        '<li>' + formatCurrencyTenThou(obj.auctionStartPrice) + '</li>\n' +
                        '<li class="borderno red"><a href="workbench/auction/toAuctionRecord.do?auctionId=' + obj.auctionId + '">竞拍</a></li>\n' +
                        '        </ul>'
                } else {
                    htmlStr += '<ul class="rows even">\n' +
                        '<li><a href="workbench/auction/toAuctionResults.do?auctionId=' + obj.auctionId + '" title="">' + obj.auctionName + '</a></li>\n' +
                        '<li class="list-wd">' + obj.auctionDesc + '</li>\n' +
                        '<li>' + obj.auctionStartTime + '</li>\n' +
                        '<li>' + obj.auctionEndTime + '</li>\n' +
                        '<li>' + formatCurrencyTenThou(obj.auctionStartPrice) + '</li>\n' +
                        '<li class="borderno red"><a href="workbench/auction/toAuctionRecord.do?auctionId=' + obj.auctionId + '">竞拍</a></li>\n' +
                        '        </ul>'
                }
            })
            // htmlStr += '<div class="page"></div>'
            $('#items').html(htmlStr);
            /*计算总页数 总条数/每页显示条数*/
            let number = Math.ceil(result.total / pageSize);
            $('#page').bs_pagination({
                currentPage: pageNum,//当前页号,相当于pageNo
                rowsPerPage: pageSize,//每页显示条数,相当于pageSize
                totalRows: result.total,//总条数
                totalPages: number,  //总页数,必填参数.
                visiblePageLinks: 5,//最多可以显示的卡片数
                showGoToPage: true,//是否显示"跳转到"部分,默认true--显示
                showRowsPerPage: true,//是否显示"每页显示条数"部分。默认true--显示
                showRowsInfo: true,//是否显示记录的信息，默认true--显示
                showRowsDefaultInfo: true,
                directURL: false,
                disableTextSelectionInNavPane: true,
                bootstrap_version: "3",

                // bootstrap 3
                containerClass: "well",

                mainWrapperClass: "row",

                navListContainerClass: "col-xs-12 col-sm-12 col-md-6",
                navListWrapperClass: "",
                navListClass: "pagination pagination_custom",
                navListActiveItemClass: "active",

                navGoToPageContainerClass: "col-xs-6 col-sm-4 col-md-2 row-space",
                navGoToPageIconClass: "glyphicon glyphicon-arrow-right",
                navGoToPageClass: "form-control small-input",

                navRowsPerPageContainerClass: "col-xs-6 col-sm-4 col-md-2 row-space",
                navRowsPerPageIconClass: "glyphicon glyphicon-th-list",
                navRowsPerPageClass: "form-control small-input",

                navInfoContainerClass: "col-xs-12 col-sm-4 col-md-2 row-space",
                navInfoClass: "",

                itemTexts: function (type, page, current) {//文字翻译可有可无
                    switch (type) {
                        case "first":
                            return "首页";
                        case "prev":
                            return "上一页";
                        case "next":
                            return "下一页";
                        case "last":
                            return "尾页";
                        case "page":
                            return page;
                    }
                },
                //用户每次切换页号，都自动触发本函数;
                //每次返回切换页号之后的pageNo和pageSize
                onChangePage: function (event, pageObj) { // returns page_num and rows_per_page after a link has clicked
                    //js代码
                    // console.log(pageObj.currentPage);
                    // console.log(pageObj.rowsPerPage);
                    queryAuctionByConditionForPage(pageObj.currentPage, pageObj.rowsPerPage);
                }
            });
        },
        error: function (error) {
            console.log("出错了")
        }
    })

}

/**
 * 金额格式化函数
 * @param num
 * @returns {*}
 */
function formatCurrencyTenThou(num) {
    num = num.toString().replace(/\$|\,/g, '');
    if (isNaN(num))
        num = "0";
    sign = (num == (num = Math.abs(num)));
    num = Math.floor(num * 10 + 0.50000000001);
    //cents = num%10;
    num = Math.floor(num / 10).toString();
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3)) + ',' +
            num.substring(num.length - (4 * i + 3));
    return (((sign) ? '' : '-') + num);
}
