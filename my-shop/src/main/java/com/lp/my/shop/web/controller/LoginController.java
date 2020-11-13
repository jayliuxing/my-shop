package com.lp.my.shop.web.controller;

import com.lp.my.shop.commons.contexts.SpringContext;
import com.lp.my.shop.commons.contexts.utils.CookieUtils;
import com.lp.my.shop.entity.User;
import com.lp.my.shop.service.UserService;
import com.lp.my.shop.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import sun.net.httpserver.HttpsServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private static final String COOKIE_NAME_USER_INFO = "userInfo";

    private UserService userService = SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req,COOKIE_NAME_USER_INFO);
        System.out.println(userInfo);
        if (!StringUtils.isBlank(userInfo)) {
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            req.setAttribute("email",email);
            req.setAttribute("password",password);
            req.setAttribute("isRemember", true);
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isRemember = req.getParameter("isRemember") == null ? false : true;
        System.out.println(isRemember);
        if (!isRemember) {
            CookieUtils.deleteCookie(req, resp, COOKIE_NAME_USER_INFO);
        }
        User admin = userService.login(email, password);
        if (null != admin) {
            if(isRemember) {
                CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s",email,password), 7 * 24 * 60 * 60);
            }
            resp.sendRedirect("/main.jsp");
        }
        else {
            req.setAttribute("message","用户名或密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
