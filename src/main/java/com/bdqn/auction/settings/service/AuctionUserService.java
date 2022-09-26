package com.bdqn.auction.settings.service;

import com.bdqn.auction.settings.entity.AuctionUser;

import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/17 14:20
 * FileName: AuctionUserService
 * Description: 用户业务层
 */
public interface AuctionUserService {
    /**
     * 保存用户
     */
    int saveAuctionUser(AuctionUser auctionUser);


    /**
     * 根据用户名和密码查询用户对象
     */
    AuctionUser queryAuctionUserByUserNameAndUserPwd(Map<String,String> map);
}
