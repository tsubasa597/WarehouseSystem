package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.controller.vo.UserFormVo;
import com.tsubasa.WarehouseSystem.util.Result;

public interface UserService {
    public Result<UserFormVo> getStaff(int page, int limit);
    public Result<UserFormVo> selectByName(int page, int limit, String name);
    public Result<Object> deletcUserById(int id);
    public Result<Object> updateUserById(UserFormVo userTableVo);
    public Result<Object> insertUser(UserFormVo userTableVo);
}