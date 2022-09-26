package com.bdqn.auction.interceptor;

import com.bdqn.auction.common.constants.ConstantsEnum;
import com.bdqn.auction.settings.entity.AuctionUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/9/20 16:15
 * FileName: LoginInterceptor
 * Description: 登录拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AuctionUser auctionUser = (AuctionUser) session.getAttribute(ConstantsEnum.SESSION_USER.getStr());
        System.out.println(auctionUser);
        if (auctionUser == null) {
            /*挑传到登录页面*/
            response.sendRedirect(request.getContextPath());
            return false;
        }
        return true;
    }
}
