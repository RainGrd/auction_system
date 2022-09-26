package com.bdqn.auction.common.constants;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/8 11:16
 * FileName: Enumeration
 * Description: 给page对象定义的枚举类
 */
public enum ConstantsEnum {
    /**
     * 传送成功的代码
     */
    PAGE_BEAN_CODE_SUCCESS("1"),
    /**
     * 传送失败的代码
     */
    PAGE_BEAN_CODE_FAIL("0"),
    /**
     * 定义年月日的常量
     */
    YMD("yyyy-MM-dd"),
    /**
     * 定义年月日时分秒的常量
     */
    YMD_HMS("yyyy-MM-dd HH:mm:ss"),
    /**
     * 保存在会话对象的当前用户的key
     */
    SESSION_USER("sessionUser"),
    /**
     * 保存在会话对象中的验证码的key
     */
    SESSION_CHECK_CODE("checkCode"),
    /**
     * office Excel文件名常量
     */
    XLS("xls"),
    /**
     * wps Excel文件名常量
     */
    XLSX("xlsx"),
    /**
     * 用户是否是管理员，0是竞拍者，1是管理员，默认值是0
     */
    AUCTION_USER_LS_ADMIN_YES("1"),
    AUCTION_USER_LS_ADMIN_NO("0"),
    /**
     * 商品状态 0是未删，1是删除
     */
    AUCTION_STATUS_SANE("0"),
    AUCTION_STATUS_DELETE("1");
    /**
     * 值
     */
    private final String str;

    ConstantsEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
