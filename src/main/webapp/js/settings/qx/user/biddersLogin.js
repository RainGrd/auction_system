$(function () {
    /*获取验证码*/
    $('#imgVerify').attr('src', "settings/qx/user/getCheckCode.do?" + Math.random())
    // console.log(imgVerify)

    /**
     * 切换验证码函数
     */
    $('#checkCodeSwitch').on('click', function () {
        getVerify();
    })
    /**
     * 注册按钮点击事件
     */
    $('#register').on('click', function () {
        window.location.href = 'settings/qx/user/toRegister.do';
    })
    let code = $.cookie("code");
    console.log("code" + code)

    /**
     * 登录按钮事件
     */
    $('#loginBtn').on('click', function () {
        /*收集参数*/
        let username = $('#name').val();
        let password = $('#password').val();
        let idRemPwd = $('#idRemPwd').prop('checked');
        let checkCode = $('#passwords').val();
        /*参数验证*/
        if (notNull(username)) {
            alert('用户名不能为空');
            return false;
        }
        if (notNull(password)) {
            alert('密码不能为空');
            return false;
        }
        console.log(username);
        let $auctionUser = {
            userName: username,
            password: password,
            idRemPwd: idRemPwd,
        }
        /*验证码判断*/
        if (notNull(checkCode)) {
            alert("验证码不能为空");
            return false;
        } else {
            $.ajax({
                url: 'settings/qx/user/sessionCheckCode.do',
                type: 'post',
                data: {
                    checkCode: checkCode
                },
                success: function (result) {
                    console.log(result);
                    if (result.code === '1') {
                        console.log($auctionUser)
                        /*发送请求*/
                        $.ajax({
                            url: 'settings/qx/user/userLogin.do',
                            type: 'post',
                            dataType: 'json',
                            contentType: "application/json",
                            data: JSON.stringify($auctionUser),
                            success: function (result) {
                                console.log(result);
                                if (result.code === '1') {
                                    console.log(result);
                                    /*跳转到拍卖品页面*/
                                    window.location.href = "workbench/auction/toAuctionList.do";
                                } else {
                                    alert(result.message);
                                }
                            }, error: function (error) {
                                console.log('出错了')
                            }
                        })
                    } else {
                        alert("验证码错误！");
                        return false;
                    }
                }, error: function (error) {
                    console.log('出错了！');
                }
            });
        }


    })
})

/**
 * 获取验证码
 */
function getVerify() {
    let imgVerify = document.getElementById("imgVerify");
    imgVerify.src = "settings/qx/user/getCheckCode.do?" + Math.random();
}

/**
 * 非空函数
 */
function notNull(value) {
    if (value === null || value === '' || value === undefined) {
        return true;
    }
}
