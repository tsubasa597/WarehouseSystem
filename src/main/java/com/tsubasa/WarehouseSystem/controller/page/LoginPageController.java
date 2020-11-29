package com.tsubasa.WarehouseSystem.controller.page;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.tsubasa.WarehouseSystem.service.LoginService;
import com.tsubasa.WarehouseSystem.util.MD5Util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginPageController {
    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "page/login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@RequestParam String user, @RequestParam String password, HttpSession httpSession) {
        Map<String, String> info = new HashMap<>();
        info.put(user, password);
        if (loginService.login(info)) {
            httpSession.setAttribute("id", MD5Util.MD5Encode(password, "UTF-8"));
            return "redirect:/main";
        } else {
            return "page/login";
        }
    }
}