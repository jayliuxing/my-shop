package com.lp.my.shop.service.impl;

import com.lp.my.shop.commons.contexts.SpringContext;
import com.lp.my.shop.dao.UserDao;
import com.lp.my.shop.entity.User;
import com.lp.my.shop.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Service(value = "userService")
public class UserServiceImpl implements UserService{

    private  UserDao userDao = SpringContext.getBean("userDao");

    @Override
    public User login(String email, String password) {
        return  userDao.getUser(email,password);
    }

    @Override
    public String sayHi() {
        return "hello!!!";
    }

}
