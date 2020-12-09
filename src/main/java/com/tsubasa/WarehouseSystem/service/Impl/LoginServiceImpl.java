package com.tsubasa.WarehouseSystem.service.Impl;

import java.util.Map;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tsubasa.WarehouseSystem.dao.UserDao;
import com.tsubasa.WarehouseSystem.entity.User;
import com.tsubasa.WarehouseSystem.service.LoginService;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserDao userDao;

    @Override
    public User login(Map<String, String> info) {
        User user = userDao.selectOne(new QueryWrapper<User>().allEq(info));
        if (user == null) {
            return user;
        } else {
            return user;
        }
    }
}