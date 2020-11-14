package com.tsubasa.WarehouseSystem.controller.page;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.service.TableDataService;
import com.tsubasa.WarehouseSystem.util.UserMenu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestPage {

    @Resource
    private TableDataService tableDataService;

    @RequestMapping(value = "/user")
    public String test(Model model) {
        /**
         * TODO : 修改 Tests, side.html
         */
        model.addAttribute("tests", UserMenu.adminMenu());
        
        return "/main";
    }
    @RequestMapping(value = "/orderManger")
    public String hello() {
        return "page/table";
    }
}