package com.tsubasa.WarehouseSystem.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsubasa.WarehouseSystem.controller.vo.UserFormVo;
import com.tsubasa.WarehouseSystem.dao.UserDao;
import com.tsubasa.WarehouseSystem.entity.User;
import com.tsubasa.WarehouseSystem.service.UserService;
import com.tsubasa.WarehouseSystem.util.BeanUtil;
import com.tsubasa.WarehouseSystem.util.MD5Util;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserDao userDao;
    
    @Override
    public Result<UserFormVo> getStaff(int page, int limit) {
        Page<User> orderPage = new Page<User>(page, limit);
        IPage<User> iPage = userDao.selectPage(orderPage, new QueryWrapper<User>().in("user_type", 0, 1));
        List<UserFormVo> tableVos = BeanUtil.copyList(iPage.getRecords(), UserFormVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<UserFormVo> selectByName(int page, int limit, String name) {
        Page<User> orderPage = new Page<User>(page, limit);
        IPage<User> iPage = userDao.selectPage(orderPage, new QueryWrapper<User>().eq("user_name", name));
        List<UserFormVo> tableVos = BeanUtil.copyList(iPage.getRecords(), UserFormVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<Object> deletcUserById(int id) {
        userDao.deleteById(id);
        return new Result<>(null, 0, "", 0);
    }

    @Override
    public Result<Object> updateUserById(UserFormVo userFormVo) {
        User user = new User();
        BeanUtil.copyProperties(userFormVo, user);
        userDao.updateById(user);
        return new Result<>(null, 0, "", 0);
    }

    @Override
    public Result<Object> insertUser(UserFormVo userFormVo) {
        User user = new User();
        BeanUtil.copyProperties(userFormVo, user);
        user.setUserPwd(MD5Util.MD5Encode(user.getUserPwd(), "UTF-8"));  
        userDao.insert(user);
        return new Result<>(null, 0, "", 0);
    }
}