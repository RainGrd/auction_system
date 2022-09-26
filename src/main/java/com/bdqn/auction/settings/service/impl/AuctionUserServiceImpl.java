package com.bdqn.auction.settings.service.impl;

import com.bdqn.auction.common.constants.ConstantsEnum;
import com.bdqn.auction.common.utils.UUIDUtils;
import com.bdqn.auction.settings.entity.AuctionUser;
import com.bdqn.auction.settings.mapper.AuctionUserMapper;
import com.bdqn.auction.settings.service.AuctionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/17 14:24
 * FileName: AuctionUserServiceImpl
 * Description: 用户业务实现层
 */
@Service("auctionUserService")
public class AuctionUserServiceImpl implements AuctionUserService {

    @Resource
    private AuctionUserMapper auctionUserMapper;

    @Override
    public int saveAuctionUser(AuctionUser auctionUser) {
        System.out.println(auctionUser);
        return auctionUserMapper.insertActionUser(auctionUser);
    }

    @Override
    public AuctionUser queryAuctionUserByUserNameAndUserPwd(Map<String,String> map) {
        return auctionUserMapper.selectAuctionUserByUserNameAndPwd(map);
    }
}
