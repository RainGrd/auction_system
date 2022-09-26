$(function () {
    /*设置验证码*/
    $("#checkCode").attr("src", "settings/qx/user/getCheckCode.do?" + new Date());

    /**
     * 注册按钮点击事件
     */
    $('#registerBtn').on('click', function () {
        /*收集表单参数*/
        let $auctionUser = {
            userName: $('#userName').val(),
            userPwd: $('#userPwd').val(),
            userCardNo: $('#cardNo').val(),
            userTel: $('#tel').val(),
            userAddress: $('#address').val(),
            userPostNumber: $('#emailNumber').val(),
        }
        /*表单验证*/
        if (notNull($auctionUser.userName)) {
            alert("用户不能为空！");
            return false;
        }
        if ($auctionUser.userName.length < 6) {
            alert("用户名按要求不低于6个字符");
            return false;
        }
        if (notNull($auctionUser.userPwd)) {
            alert("密码不能为空")
            return false;
        }
        if ($auctionUser.userPwd.length < 6) {
            alert("密码按要求不低于6个字符！");
            return false;
        }
        /*身份证号码*/
        if (!/^\d{15}|\d{18}$/.test($auctionUser.userCardNo)) {
            alert("身份证格式错误！");
            return false;
        }
        if (notNull($auctionUser.userTel)) {
            alert("电话号码不能为空！");
            return false;
        }
        /*电话号码*/
        if (!/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test($auctionUser.userTel)) {
            alert("电话号码格式错误");
            return false;
        }
        if (notNull($auctionUser.userPostNumber)) {
            alert("邮政编码不能为空！");
            return false;
        }
        console.log(/[1-9]\d{4}(?!\d)/.test($auctionUser.userPostNumber))
        if (!/[1-9]\d{4}(?!\d)/.test($auctionUser.userPostNumber)) {
            alert("邮政编码格式错误");
            return false;
        }
        let checkCode = $('#imgVerify').val();
        /**
         * 验证码非空判断
         */
        if (notNull(checkCode)) {
            $('#imgVerify').addClass("borderRed");
            return false;
        } else {
            $.ajax({
                url: 'settings/qx/user/sessionCheckCode.do',
                type: 'post',
                data: {
                    checkCode: checkCode
                },
                success: function (result) {
                    if (result.code === '1') {
                        /*发送请求*/
                        $.ajax({
                            url: 'settings/qx/user/userRegistered.do',
                            type: 'post',
                            contentType: 'application/json',
                            dataType: 'json',
                            data: JSON.stringify($auctionUser),
                            success: function (result) {
                                console.log(result)
                                if (result.code === '1') {
                                    /*跳转到登录页面*/
                                    window.location.href = 'settings/qx/user/toLogin.do';
                                } else {
                                    alert(result.message);
                                }
                            },
                            error: function (error) {
                                console.log('出错了')
                            }
                        });
                    } else {
                        alert("验证码错误！");
                        return false;
                    }
                }, error: function (error) {
                    console.log('出错了！');
                }
            });
        }

    });
    /**
     * 验证码按钮点击事件
     */
    $('#checkCodeSwitch').on('click', function (e) {
        getVerify();
        /*不跳转*/
        // stopDefault(e);
    });


})

/*获取验证码*/
function getVerify() {
    let checkCode = document.getElementById("checkCode");
    checkCode.src = "settings/qx/user/getCheckCode.do?" + new Date();
}

function stopDefault(e) {

    if (e && e.preventDefault)

        e.preventDefault();

    else

        window.event.returnValue = false;

    return false;

}

/**
 * 非空函数
 */
function notNull(value) {
    if (value === null || value === '' || value === undefined) {
        return true;
    }
}


