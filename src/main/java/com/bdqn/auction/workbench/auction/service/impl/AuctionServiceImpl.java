package com.bdqn.auction.workbench.auction.service.impl;

import com.bdqn.auction.common.utils.DateTimeUtil;
import com.bdqn.auction.workbench.auction.entity.Auction;
import com.bdqn.auction.workbench.auction.mapper.AuctionMapper;
import com.bdqn.auction.workbench.auction.service.AuctionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/19 20:34
 * FileName: AuctionServiceImpl
 * Description: 商品列表业务实现层
 */
@Service("auctionService")
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionMapper auctionMapper;

    @Override
    public PageInfo<Auction> queryAuctionByConditionForPage(Map<String, String> map) {
        int pageNum = Integer.parseInt(map.get("pageNum"));
        int pageSize = Integer.parseInt(map.get("pageSize"));
        System.out.println(pageNum);
        System.out.println(pageSize);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Auction> pageInfo = new PageInfo<>();
        List<Auction> auctions = auctionMapper.selectAuctionByConditionForPage(map);
        for (Auction auction : auctions) {
            System.out.println("auction = " + auction);
        }
        pageInfo.setList(auctions);
        pageInfo.setTotal(auctionMapper.selectCountByConditionForPage(map));
        return pageInfo;
    }

    @Override
    public int deleteAuctionById(String id) {
        return auctionMapper.deleteAuctionById(id);
    }

    @Override
    public int saveAuction(Auction auction) {
        return auctionMapper.insertAuction(auction);
    }

    @Override
    public Auction queryAuctionBuId(String id) {
        return auctionMapper.selectAuctionById(id);
    }

    @Override
    public int updateAuction(Auction auction) {
        return auctionMapper.updateAuction(auction);
    }
}
