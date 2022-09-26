package com.bdqn.auction.service.test;

import com.bdqn.auction.settings.entity.AuctionUser;
import com.bdqn.auction.settings.service.AuctionUserService;
import com.bdqn.auction.workbench.auction.service.AuctionRecordService;
import com.bdqn.auction.workbench.auction.service.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/17 14:52
 * FileName: AuctionUserServiceTest
 * Description: 用户业务测试层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AuctionUserServiceTest {

    @Autowired
    private AuctionUserService auctionUserService;

    @Autowired
    private AuctionRecordService auctionRecordService;
    @Autowired
    private AuctionService auctionService;

    @Test
    public void queryAuctionRecordByAuctionUserIdAndAuctionIdTest() {
        System.out.println(auctionRecordService.queryAuctionRecordByAuctionUserIdAndAuctionId("accee9d2ae9e452ba7418c1c5b1136b4"));
    }

    @Test
    public void saveAuctionUserTest() {
        AuctionUser auctionUser = new AuctionUser();
        auctionUserService.saveAuctionUser(auctionUser);
    }

    @Test
    public void queryAuctionUserByUserNameAndUserPwdTest() {
        Map<String, String> map = new HashMap<>();
        map.put("userName", "lisi");
        map.put("password", "123456");
        System.out.println(auctionUserService.queryAuctionUserByUserNameAndUserPwd(map));
    }

    @Test
    public void selectAuctionRecordByAuctionTest() {
        System.out.println(auctionRecordService.queryAuctionRecordByUserId("98f784816b1140a7b72c4a034e997842"));
    }

    @Test
    public void queryAuctionRecordByAuctionEndTimeTest() {
        System.out.println(auctionRecordService.queryAuctionRecordListByAuctionId("98f784816b1140a7b72c4a034e997842"));
    }
}
