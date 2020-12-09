package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.UserFormVo;
import com.tsubasa.WarehouseSystem.service.UserService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * TODO : 获取全部列表
     */
    @RequestMapping(value = "/staff", method = RequestMethod.GET)
    public Result<UserFormVo> getUsers(@RequestParam int page, int limit) {
        return userService.getStaff(page, limit);
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public Result<UserFormVo> selectByUserName(@RequestParam int page, int limit, String name) {
        return userService.selectByName(page, limit, name);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public Result<Object> deleteUserById(@RequestParam int id) {
        return userService.deletcUserById(id);
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Result<Object> insertUser(UserFormVo userFormVo) {
        return userService.insertUser(userFormVo);
    }

}