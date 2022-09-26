package com.bdqn.auction.workbench.auction.controller;

import com.bdqn.auction.common.constants.ConstantsEnum;
import com.bdqn.auction.common.utils.ImageUtils;
import com.bdqn.auction.common.utils.UUIDUtils;
import com.bdqn.auction.settings.entity.AuctionUser;
import com.bdqn.auction.vo.PageBean;
import com.bdqn.auction.workbench.auction.entity.Auction;
import com.bdqn.auction.workbench.auction.entity.AuctionRecord;
import com.bdqn.auction.workbench.auction.service.AuctionRecordService;
import com.bdqn.auction.workbench.auction.service.AuctionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/20 8:10
 * FileName: AuctionController
 * Description: 商品列表控制层
 */
@Controller
public class AuctionController {

    @Autowired
    private AuctionService auctionService;
    @Autowired
    private AuctionRecordService auctionRecordService;

    /**
     * 跳转商品列表页面
     */
    @RequestMapping("/workbench/auction/toAuctionList.do")
    public String toAuctionList(HttpSession session) {
        AuctionUser auctionUser = (AuctionUser) session.getAttribute(ConstantsEnum.SESSION_USER.getStr());
        /*根据存放在云端的用户对象来判断是否管理员登录还是普通用户登录*/
        if ("1".equals(auctionUser.getUserLsAdmin())) {
            return "workbench/auction/auctionManagement";
        }
        return "workbench/auction/auctionList";
    }

    /**
     * 根据分页条件进行分页查询
     */
    @RequestMapping("/workbench/auction/queryAuctionByConditionForPage.do")
    @ResponseBody
    public String queryAuctionByConditionForPage(@RequestBody Map<String, String> map, HttpSession session) throws JsonProcessingException {
        PageInfo<Auction> auctionPageInfo = auctionService.queryAuctionByConditionForPage(map);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(auctionPageInfo);
    }

    /**
     * 根据id删除商品
     */
    @RequestMapping("/workbench/auction/deleteAuctionById.do")
    @ResponseBody
    public Object deleteAuctionById(String auctionId) {
        PageBean pageBean = new PageBean();
        try {
            int auctionById = auctionService.deleteAuctionById(auctionId);
            if (auctionById > 0) {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_SUCCESS.getStr());
            } else {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
                pageBean.setMessage("系统忙，正在维护中");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageBean;
    }

    /**
     * 插入商品
     */
    @RequestMapping("/workbench/auction/saveAuction.do")
    @ResponseBody
    public Object saveAuction(@RequestBody Auction auction) {
        /*设置id和商品状态*/
        auction.setAuctionId(UUIDUtils.getUUID());
        auction.setAuctionStatus(Integer.valueOf(ConstantsEnum.AUCTION_STATUS_SANE.getStr()));
        System.out.println(auction);
        PageBean pageBean = new PageBean();
        try {
            /*执行插入方法*/
            int saveAuction = auctionService.saveAuction(auction);
            if (saveAuction > 0) {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_SUCCESS.getStr());
            } else {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
                pageBean.setMessage("系统忙正在维护中!");
            }
        } catch (Exception e) {
            pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
            pageBean.setMessage("系统忙正在维护中!");
            e.printStackTrace();
        }
        return pageBean;
    }

    /**
     * 图片回显
     */
    @RequestMapping("/workbench/auction/fileUpload.do")
    @ResponseBody
    public Object fileUpload(MultipartFile picFile, HttpServletRequest request) throws IOException {
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(picFile.getOriginalFilename());
        ObjectMapper objectMapper = new ObjectMapper();
        if (picFile != null) {
            String upload = ImageUtils.upload(request, picFile);
            System.out.println(upload);
            objectObjectHashMap.put("img_url", upload);
        } else {
            objectObjectHashMap.put("img_url", ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
        }
        return objectMapper.writeValueAsString(objectObjectHashMap);
    }

    /**
     * 跳转到增加页面
     */
    @RequestMapping("/workbench/auction/toInsertAuction.do")
    public String toInsertAuction() {
        return "workbench/auction/insertAuction";
    }

    /**
     * 跳转到修改商品页面
     */
    @RequestMapping("/workbench/auction/toUpdateAuction.do")
    public ModelAndView toUpdateAuction(@RequestParam("auctionId") String auctionId) {
        ModelAndView modelAndView = new ModelAndView();
        Auction auction = auctionService.queryAuctionBuId(auctionId);
        modelAndView.addObject("auction", auction);
        modelAndView.addObject("enter", "\n");
        modelAndView.setViewName("workbench/auction/updateAuction");
        return modelAndView;
    }

    /**
     * 修改商品
     */
    @RequestMapping("/workbench/auction/updateAuction.do")
    @ResponseBody
    public Object updateAuction(@RequestBody Auction auction) {
        System.out.println(auction);
        PageBean pageBean = new PageBean();
        try {
            int updateAuction = auctionService.updateAuction(auction);
            if (updateAuction > 0) {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_SUCCESS.getStr());
            } else {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
                pageBean.setMessage("系统忙，正在维护中！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
            pageBean.setMessage("系统忙，正在维护中！");
        }
        return pageBean;
    }


}
