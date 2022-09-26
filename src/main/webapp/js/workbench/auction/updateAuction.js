$(function () {
    /**
     * 取消按钮点击事件
     */
    $('#cancel').on('click', function () {
        window.history.back();
    });
    /**
     * 保存按钮点击事件
     */
    $("#updateAuctionBtn").on('click', function () {
        let imageUrl = $('#image_url').val();
        let auctionPic = imageUrl.substr(0, imageUrl.lastIndexOf('.'));
        console.log(auctionPic);
        /*收集参数*/
        let $auction = {
            auctionId: $('#auctionId').val(),
            auctionName: $('#auctionName').val(),
            auctionStartPrice: $('#auctionStartPrice').val(),
            auctionUpset: $('#auctionUpset').val(),
            auctionStartTime: $('#auctionStartTime').val(),
            auctionEndTime: $('#auctionEndTime').val(),
            auctionPic: auctionPic,
            auctionPicType: imageUrl.substr(imageUrl.lastIndexOf('.')),
            auctionDesc: $('#auctionDesc').val(),
            auctionStatus: $('#auctionStatus').val(),
        }
        console.log($auction)
        /*表单验证*/
        //非空验证
        if (notNull($auction.auctionName)) {
            alert("名称不能为空");
            return false;
        }
        if (notNull(imageUrl)) {
            alert("图片不能为空");
            return false;
        }
        if (notNull($auction.auctionDesc)) {
            alert("描述不能为空");
            return false;
        }
        //数字验证
        if (!checkNumber($auction.auctionStartPrice.substr(0, $auction.auctionStartPrice.lastIndexOf('.')))) {
            $('#auctionStartPrice').siblings("div").removeClass('hide');
            return false;
        }
        if (!checkNumber($auction.auctionUpset.substr(0, $auction.auctionUpset.lastIndexOf('.')))) {
            $('#auctionUpset').siblings("div").removeClass('hide');
            return false;
        }
        //时间验证
        if (!checkDataTime($auction.auctionStartTime)) {
            $('#auctionStartTime').siblings("div").removeClass('hide');
            return false;
        }
        if (!checkDataTime($auction.auctionEndTime)) {
            $('#auctionEndTime').siblings("div").removeClass('hide');
            return false;
        }
        console.log(1)
        /*发送参数*/
        $.ajax({
            url: "workbench/auction/updateAuction.do",
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify($auction),
            success: function (result) {
                console.log(result);
                if (result.code === '1') {
                    /*跳转到商品列表页*/
                    window.location.href = "workbench/auction/toAuctionList.do";
                } else {
                    alert(result.message)
                }
            }, error: function (error) {
                console.log('出错了')
            }
        })
    })
})

/**
 * 文件上传
 */
function fileChange() {
    let picFile = $('#picFile').val();
    /*获取*/
    $.ajaxFileUpload({
        url: 'workbench/auction/fileUpload.do',
        /*安全协议*/
        secureuri: false,
        fileElementId: 'picFile',
        dataType: 'text',
        success: function (result) {
            console.log(result)
            /*设置img对象*/
            var imgObj = $('<img>')
            let imgURl = JSON.parse(result);
            if (imgURl.img_url.length !== 0) {
                console.log(1)
                /*清空原有数据*/
                $('#pic').empty();
                /*设置属性*/
                imgObj.attr('src', $('#path').prop('href') + imgURl.img_url);
                imgObj.attr('width', "100");
                imgObj.attr('height', '100');
                $('#image_url').val(imgURl.img_url);
                /*拼接*/
                $('#pic').append(imgObj);
            }
        }, error: function (error) {
            let parse = JSON.parse(error.responseText);
            if (notNull(parse.img_url)) {
                $('#picFile').val(picFile);
            }
            console.log('出错了')
        }
    });
}

/**
 * 时间格式验证
 */
function checkDataTime(dataTime) {
    let regs = /^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;
    if (!regs.test(dataTime)) {
        return false;
    } else {
        return true;
    }
}

/**
 * 检验是否是数字的验证
 */
function checkNumber(number) {
    if (!/^[0-9]+(.[0-9]{1,2})?$/.test(number)) {
        return false;
    } else {
        return true;
    }

}

/**
 * 非空函数
 */
function notNull(value) {
    if (value === null || value === '' || value === undefined) {
        return true;
    }
}