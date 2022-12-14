package com.bdqn.auction.common.utils;

import java.util.UUID;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/17 15:03
 * FileName: UUIDUtils
 * Description: UUID工具类
 */
public class UUIDUtils {
    /**
     * 用户获取UUID的值，UUID的值为32位
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
