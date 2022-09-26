package com.bdqn.auction.workbench.auction.service.impl;

import com.bdqn.auction.workbench.auction.entity.AuctionRecord;
import com.bdqn.auction.workbench.auction.mapper.AuctionRecordMapper;
import com.bdqn.auction.workbench.auction.service.AuctionRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/21 20:23
 * FileName: AuctionRecordServiceImpl
 * Description: 竞拍商品业务实现层
 */
@Service("auctionRecordService")
public class AuctionRecordServiceImpl implements AuctionRecordService {
    @Resource
    private AuctionRecordMapper auctionRecordMapper;

    @Override
    public List<AuctionRecord> queryAuctionRecordByAuctionUserIdAndAuctionId(String auctionId) {
        return auctionRecordMapper.selectAuctionRecordListByAuctionId(auctionId);
    }

    @Override
    public int saveAuctionRecord(AuctionRecord auctionRecord) {
        return auctionRecordMapper.insertAuctionRecord(auctionRecord);
    }

    @Override
    public List<AuctionRecord> queryAuctionRecordByUserId(String userId) {
        return auctionRecordMapper.selectAuctionRecordByUserId(userId);
    }

    @Override
    public AuctionRecord queryAuctionRecordListByAuctionId(String auctionId) {
        return auctionRecordMapper.selectAuctionRecordByAuctionId(auctionId);
    }

    @Override
    public List<AuctionRecord> queryAuctionRecordByAuctionIdAndEndTime(String auctionId) {
        return auctionRecordMapper.selectAuctionRecordByAuctionIdAndEndTime(auctionId);
    }

    @Override
    public List<AuctionRecord> queryAuctionRecordUserByEndTime() {
        return auctionRecordMapper.selectAuctionRecordUserByEndTime();
    }
}
