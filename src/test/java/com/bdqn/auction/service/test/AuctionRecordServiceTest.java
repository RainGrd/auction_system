package com.bdqn.auction.service.test;

import com.bdqn.auction.workbench.auction.entity.Auction;
import com.bdqn.auction.workbench.auction.entity.AuctionRecord;
import com.bdqn.auction.workbench.auction.service.AuctionRecordService;
import com.bdqn.auction.workbench.auction.service.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/26 15:05
 * FileName: AuctionServiceTest
 * Description: 商品业务测试层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AuctionRecordServiceTest {
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private AuctionRecordService auctionRecordService;

    @Test
    public void queryAuctionRecordByUserIdTest() {
        List<AuctionRecord> auctionRecordList = auctionRecordService.queryAuctionRecordByUserId("d1a0bdf4ac4b48c69b33f0fdab05cac4");
        System.out.println(auctionRecordList);
        List<AuctionRecord> auctionRecords = new ArrayList<>();
        List<AuctionRecord >records=null;
        for (AuctionRecord auctionRecord : auctionRecordList) {
            Auction auction = auctionRecord.getAuction();
            AuctionRecord record = auctionRecordService.queryAuctionRecordListByAuctionId(auction.getAuctionId());
            auctionRecords.add(record);
            records = auctionRecordService.queryAuctionRecordByAuctionIdAndEndTime(auction.getAuctionId());
        }
        System.out.println(auctionRecords);
        System.out.println("records = " + records);
/*        for (AuctionRecord record : records) {
            System.out.println("record = " + record);
        }*/
        /*根据查询出来的商品的Id查询当前用户竞拍过的商品的信息*/
    }

    @Test
    public void queryAuctionRecordUserByEndTimeTest() {
        List<AuctionRecord> records = auctionRecordService.queryAuctionRecordUserByEndTime();
        System.out.println("records = " + records);
        for (AuctionRecord record : records) {
            System.out.println("record = " + record);
        }
    }
}
