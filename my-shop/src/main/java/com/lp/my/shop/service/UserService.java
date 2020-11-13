package com.lp.my.shop.service;

import com.lp.my.shop.entity.User;

public interface UserService {
    public User login(String email,String password);

    public String sayHi();
}
