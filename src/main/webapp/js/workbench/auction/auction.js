$(function () {
    /**
     * 返回列表按钮点击事件
     */
    $("#returnsListBtn").on('click', function () {
        window.location.href = 'workbench/auction/toAuctionList.do';
    })
    /**
     * 竞拍按钮点击事件
     */
    $('#auctionBtn').on("click", function () {
        let auctionStartPrice = $('#auctionStartPrice').text();

        /*收集参数*/
        let sale = $('#sale').val();
        /*表单验证*/
        if(sale<auctionStartPrice){
            $('#auctionPrice').removeClass("hide");
            return false;
        }

        let auctionId = $('#auctionId').text();
        $.ajax({
            url: 'workbench/auction/saveAuctionRecord.do',
            type: 'post',
            dataType: 'json',
            data: {
                auctionId: auctionId,
                auctionPrice: sale,
            },
            success: function (result) {
                console.log(result);
            }, error: function (error) {
                // console.log(error);
                console.log('出错了');
            }
        })
    });
})