package com.lp.my.shop.web.controller;

import com.lp.my.shop.commons.contexts.SpringContext;
import com.lp.my.shop.entity.User;
import com.lp.my.shop.service.UserService;
import sun.net.httpserver.HttpsServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpringContext context = new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User admin = userService.login("admin123@.com","admin");
        System.out.println(admin);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        SpringContext context = new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User admin = userService.login(email, password);
        if (null != admin) {
            resp.sendRedirect("/main.jsp");
        }
        else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
