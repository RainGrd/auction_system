package com.bdqn.auction.workbench.auction.controller;

import com.bdqn.auction.common.constants.ConstantsEnum;
import com.bdqn.auction.common.utils.DateTimeUtil;
import com.bdqn.auction.common.utils.UUIDUtils;
import com.bdqn.auction.settings.entity.AuctionUser;
import com.bdqn.auction.settings.service.AuctionUserService;
import com.bdqn.auction.vo.PageBean;
import com.bdqn.auction.workbench.auction.entity.Auction;
import com.bdqn.auction.workbench.auction.entity.AuctionRecord;
import com.bdqn.auction.workbench.auction.service.AuctionRecordService;
import com.bdqn.auction.workbench.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/22 8:11
 * FileName: AuctionRecordController
 * Description: 竞拍商品控制层
 */
@Controller
public class AuctionRecordController {

    @Autowired
    private AuctionRecordService auctionRecordService;
    @Autowired
    private AuctionUserService auctionUserService;
    @Autowired
    private AuctionService auctionService;

    /**
     * 跳转到商品竞拍页
     */
    @RequestMapping("/workbench/auction/toAuctionRecord.do")
    public ModelAndView toAuctionRecord(@RequestParam("auctionId") String auctionId) {
        ModelAndView modelAndView = new ModelAndView();
        /*执行查询方法*/
        List<AuctionRecord> auctionRecords = auctionRecordService.queryAuctionRecordByAuctionUserIdAndAuctionId(auctionId);
        Auction auction = auctionService.queryAuctionBuId(auctionId);
        /*添加数据*/
        modelAndView.addObject("auction", auction);
        modelAndView.addObject("auctionRecords", auctionRecords);
        /*设置跳转视图*/
        modelAndView.setViewName("workbench/auction/auction");
        return modelAndView;
    }

    /**
     * 保存竞拍商品
     */
    @RequestMapping("/workbench/auction/saveAuctionRecord.do")
    @ResponseBody
    public Object saveAuctionRecord(@RequestParam String auctionId, @RequestParam BigDecimal auctionPrice, HttpSession session) {
        PageBean pageBean = new PageBean();
        AuctionRecord auctionRecord = new AuctionRecord();
        AuctionUser auctionUser = (AuctionUser) session.getAttribute(ConstantsEnum.SESSION_USER.getStr());
        System.out.println(auctionUser);
        Auction auction = auctionService.queryAuctionBuId(auctionId);
        auctionRecord.setId(UUIDUtils.getUUID());
        auctionRecord.setAuction(auction);
        auctionRecord.setAuctionTime(DateTimeUtil.convertDateCustomStringFormat(new Date()));
        auctionRecord.setAuctionUser(auctionUser);
        auctionRecord.setAuctionPrice(auctionPrice);
        System.out.println(auctionRecord);
        try {
            int saveAuctionRecord = auctionRecordService.saveAuctionRecord(auctionRecord);
            if (saveAuctionRecord > 0) {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_SUCCESS.getStr());
            } else {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
                pageBean.setMessage("系统忙，正在维护中");
            }
        } catch (Exception e) {
            pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
            pageBean.setMessage("系统忙，正在维护中");
            e.printStackTrace();
        }
        return pageBean;
    }

    /**
     * 跳转竞拍结果页
     */
    @RequestMapping("/workbench/auction/toAuctionResults.do")
    public ModelAndView toAuctionResults(HttpSession session) {
        AuctionUser auctionUser = (AuctionUser) session.getAttribute(ConstantsEnum.SESSION_USER.getStr());
        System.out.println(auctionUser);
        ModelAndView modelAndView = new ModelAndView();
        /*根据用户Id查询他拍卖的商品*/
        List<AuctionRecord> auctionRecords = auctionRecordService.queryAuctionRecordByUserId(auctionUser.getUserId());
        List<AuctionRecord> auctionRecordList = new ArrayList<>();
        List<AuctionRecord> auctionRecordArrayList = null;
        for (AuctionRecord auctionRecord : auctionRecords) {
            Auction auction = auctionRecord.getAuction();
            /*根据查询出来的商品Id查询当前用户竞拍过的商品的信息*/
            AuctionRecord record = auctionRecordService.queryAuctionRecordListByAuctionId(auction.getAuctionId());
            System.out.println("record = " + record);
            auctionRecordList.add(record);
            System.out.println(record);
            auctionRecordArrayList = auctionRecordService.queryAuctionRecordByAuctionIdAndEndTime(auctionRecord.getAuction().getAuctionId());
        }
        System.out.println(auctionRecordArrayList);
        List<AuctionRecord> records = auctionRecordService.queryAuctionRecordUserByEndTime();
        /*存放数据*/
        //modelAndView.addObject("auctionRecords", auctionRecords);
        modelAndView.addObject("auctionRecordList", auctionRecordList);
        modelAndView.addObject("auctionRecordArrayList", auctionRecordArrayList);
        System.out.println(auctionRecordArrayList);
        modelAndView.addObject("records", records);
        System.out.println(records);
        for (AuctionRecord record : records) {
            System.out.println(record);

        }
        modelAndView.setViewName("workbench/auction/auctionResults");
        return modelAndView;
    }

}
