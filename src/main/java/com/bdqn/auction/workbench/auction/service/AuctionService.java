package com.bdqn.auction.workbench.auction.service;

import com.bdqn.auction.workbench.auction.entity.Auction;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/19 20:33
 * FileName: AuctionService
 * Description: 商品列表业务层
 */
public interface AuctionService {
    /**
     * 根据分页条件查询分页数据
     */
    PageInfo<Auction> queryAuctionByConditionForPage(Map<String, String> map);

    /**
     * 根据id删除商品
     */
    int deleteAuctionById(String id);

    /**
     * 插入商品对象
     */
    int saveAuction(Auction auction);
    /**
     * 根据id查询商品
     */
    Auction queryAuctionBuId(String id);
    /**
     * 修改商品
     */
    int updateAuction(Auction auction);
}
