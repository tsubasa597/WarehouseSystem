package com.tsubasa.WarehouseSystem.controller.page;

import com.tsubasa.WarehouseSystem.service.page.UserPageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestPage {
    @Autowired
    private UserPageService userPageService;

    @RequestMapping(value = "/user")
    public String test(Model model) {
        model.addAttribute("tests", userPageService.addMenu());
        return "/main";
    }
    @RequestMapping(value = "test")
    public String hello(Model model) {
        model.addAttribute("tests", userPageService.addMenu());
        return "/layout/side";
    }
}