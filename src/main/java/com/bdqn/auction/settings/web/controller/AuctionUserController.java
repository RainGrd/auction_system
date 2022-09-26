package com.bdqn.auction.settings.web.controller;

import com.bdqn.auction.common.constants.ConstantsEnum;
import com.bdqn.auction.common.utils.CheckCodeUtil;
import com.bdqn.auction.common.utils.UUIDUtils;
import com.bdqn.auction.settings.entity.AuctionUser;
import com.bdqn.auction.settings.service.AuctionUserService;
import com.bdqn.auction.vo.PageBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/17 12:24
 * FileName: UserController
 * Description: 用户控制层
 */
@Controller
public class AuctionUserController {

    @Autowired
    private AuctionUserService auctionUserService;

    /**
     * 用户登录页面
     */
    @RequestMapping("/settings/qx/user/toLogin.do")
    public String toLogin() {
        return "settings/qx/user/biddersLogin";
    }

    /**
     * 用户注册页面
     *
     * @return
     */
    @RequestMapping("/settings/qx/user/toRegister.do")
    public String toRegister() {
        return "settings/qx/user/biddersRegister";
    }

    /**
     * 验证码方法
     */
    @RequestMapping("/settings/qx/user/getCheckCode.do")
    public void getCheckCode(HttpServletResponse response, HttpSession session) throws IOException {
        /*告诉浏览器，我输出的内容是图片*/
        response.setContentType("image/jpg");
        /*告诉浏览器不需要缓存此内容*/
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expire", 0);
        ServletOutputStream outputStream = response.getOutputStream();
        /*获取验证码*/
        String checkCode = CheckCodeUtil.outputVerifyImage(96, 35, outputStream, 4);
        Cookie code = new Cookie("code", checkCode);
        code.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(code);
        System.out.println(code.getName()+code.getValue());
        session.removeAttribute(ConstantsEnum.SESSION_CHECK_CODE.getStr());
        session.setAttribute(ConstantsEnum.SESSION_CHECK_CODE.getStr(), checkCode);
        session.getAttribute(ConstantsEnum.SESSION_CHECK_CODE.getStr());
    }

    /**
     * 用户登录方法
     */
    @RequestMapping("settings/qx/user/userLogin.do")
    @ResponseBody
    public Object userLogin(@RequestBody Map<String, String> map, HttpSession session, HttpServletResponse response) {
        System.out.println(map);
        /*获取自动登录的标识*/
        String idRemPwd = map.get("idRemPwd");
        System.out.println(idRemPwd);
        PageBean pageBean = new PageBean();
        /*获取是否需要*/
        try {
            AuctionUser auctionUser = auctionUserService.queryAuctionUserByUserNameAndUserPwd(map);
            if (auctionUser != null) {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_SUCCESS.getStr());
                /*将用户对象保存在会话对象中*/
                session.setAttribute(ConstantsEnum.SESSION_USER.getStr(), auctionUser);
                /*将用户和密码存入cookie中*/
                Cookie username = new Cookie("username", auctionUser.getUserName());
                Cookie password = new Cookie("password", auctionUser.getUserPwd());
                /*判断是否需要自动登录*/
                if ("true".equals(idRemPwd)) {
                    /*指定cookie的存活时间 7天*/
                    username.setMaxAge(7 * 24 * 60 * 60);
                    password.setMaxAge(7 * 24 * 60 * 60);
                    /*响应数据*/
                    response.addCookie(username);
                    response.addCookie(password);
                } else {
                    /*清除cookie*/
                    //指定cookie的存活时间
                    username.setMaxAge(0);
                    password.setMaxAge(0);
                    //响应数据
                    response.addCookie(username);
                    response.addCookie(password);
                }
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

    /**
     * 获取session的验证码
     */
    @RequestMapping("/settings/qx/user/sessionCheckCode.do")
    @ResponseBody
    public Object sessionCheckCode(String checkCode, HttpSession session) throws JsonProcessingException {
        String sessionCheckCode = (String) session.getAttribute(ConstantsEnum.SESSION_CHECK_CODE.getStr());
        System.out.println("checkCode:" + checkCode);
        PageBean pageBean = new PageBean();
        if (checkCode.equalsIgnoreCase(sessionCheckCode)) {
            pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_SUCCESS.getStr());
        } else {
            pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
        }
        System.out.println(pageBean);
        return pageBean;
    }

    /**
     * 用户注册方法
     */
    @RequestMapping("/settings/qx/user/userRegistered.do")
    @ResponseBody
    public Object userRegistered(@RequestBody AuctionUser auctionUser) {
        PageBean pageBean = new PageBean();
        /*封装数据*/
        auctionUser.setUserId(UUIDUtils.getUUID());
        auctionUser.setUserLsAdmin(ConstantsEnum.AUCTION_USER_LS_ADMIN_NO.getStr());
        try {
            int saveAuctionUser = auctionUserService.saveAuctionUser(auctionUser);
            if (saveAuctionUser > 0) {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_SUCCESS.getStr());
            } else {
                pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
                pageBean.setMessage("系统忙！正在维护中！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageBean.setCode(ConstantsEnum.PAGE_BEAN_CODE_FAIL.getStr());
            pageBean.setMessage("系统忙！正在维护中！");
        }
        return pageBean;
    }

    /**
     * 注销方法
     */
    @RequestMapping("/settings/qx/user/loginExit.do")
    public String loginExit(HttpSession session) {
        /*移除用户对象*/
        session.removeAttribute(ConstantsEnum.SESSION_USER.getStr());
        /*退出到登录页面*/
        return "settings/qx/user/biddersLogin";
    }
}
