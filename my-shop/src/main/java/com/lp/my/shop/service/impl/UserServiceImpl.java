package com.lp.my.shop.service.impl;

import com.lp.my.shop.commons.contexts.SpringContext;
import com.lp.my.shop.dao.UserDao;
import com.lp.my.shop.entity.User;
import com.lp.my.shop.service.UserService;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class UserServiceImpl implements UserService{


    @Override
    public User login(String email, String password) {
        SpringContext context  = new SpringContext();
        UserDao userDao = (UserDao) context.getBean("userDao");
        return  userDao.getUser(email,password);
    }
}
