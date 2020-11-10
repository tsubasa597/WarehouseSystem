package com.tsubasa.WarehouseSystem.controller.page;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.service.page.UserPageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestPage {
    @Resource
    private UserPageService userPageService;

    @RequestMapping(value = "/user")
    public String test(Model model) {
        /**
         * TODO : 修改 Tests
         */
        model.addAttribute("tests", userPageService.addMenu());
        return "/main";
    }
    @RequestMapping(value = "/page/table")
    public String hello() {
        return "/page/table";
    }
}