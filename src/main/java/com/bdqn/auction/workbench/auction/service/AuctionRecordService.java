package com.bdqn.auction.workbench.auction.service;

import com.bdqn.auction.workbench.auction.entity.AuctionRecord;

import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/21 20:22
 * FileName: AuctionRecordService
 * Description: 竞拍商品业务层
 */
public interface AuctionRecordService {
    /**
     * 根据竞拍商品ID查询竞拍商品
     */
    List<AuctionRecord> queryAuctionRecordByAuctionUserIdAndAuctionId(String auctionId);

    /**
     * 保存竞拍商品
     */
    int saveAuctionRecord(AuctionRecord auctionRecord);

    /**
     * 根据用户Id去查询其拍卖过的商品
     */
    List<AuctionRecord> queryAuctionRecordByUserId(String userId);
    /**
     * 根据查询出来的商品Id查询当前用户竞拍过的商品
     */
    AuctionRecord queryAuctionRecordListByAuctionId(String auctionId);
    /**
     * 根据查询出来的商品Id查询当前用户竞拍过的商品
     */
    List<AuctionRecord> queryAuctionRecordByAuctionIdAndEndTime(String auctionId);
    /**
     * 查询正在拍卖商品的用户
     */
    List<AuctionRecord> queryAuctionRecordUserByEndTime();
}
