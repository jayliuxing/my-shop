package com.lp.my.shop.dao;

import com.lp.my.shop.entity.User;

public interface UserDao {

    public User getUser(String email,String password);
}
