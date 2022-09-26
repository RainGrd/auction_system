package com.bdqn.auction.vo;

import lombok.Data;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/17 14:29
 * FileName: PageBean
 * Description: 传输类
 */
@Data
public class PageBean {
    /**
     * 成功或失败的标识
     */
    private String code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

}
