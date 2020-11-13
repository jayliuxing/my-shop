package com.lp.my.shop.dao.impl;

import com.lp.my.shop.dao.UserDao;
import com.lp.my.shop.entity.User;
import com.lp.my.shop.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User getUser(String email, String password) {
        logger.debug("调试 getUser(), email: {} password: {}", email,password);

        User user = new User();
        if ("admin@163.com".equals(email)) {
            if ("admin".equals(password)) {
                user.setEmail("admin@163.com");
                user.setUsername("jaychou");
                user.setPassword("admin");

                logger.info("成功获取 \"{}\" 的用户信息", user.getUsername());
            }
        }
        else {
            user = null;
            logger.warn("获取 \"{}\" 用户信息失败", email);
        }
        return user;
    }
}
