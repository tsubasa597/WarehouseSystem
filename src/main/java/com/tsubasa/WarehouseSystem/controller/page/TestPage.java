package com.tsubasa.WarehouseSystem.controller.page;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.service.OrderService;
import com.tsubasa.WarehouseSystem.util.UserMenu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestPage {

    @Resource
    private OrderService tableDataService;

    @RequestMapping(value = "/user")
    public String test(Model model) {
        /**
         * TODO : 修改 Tests, side.html
         */
        model.addAttribute("tests", UserMenu.adminMenu());
        
        return "/main";
    }
    @RequestMapping(value = "/orderManger")
    public String orderManger() {
        return "page/table";
    }

    @RequestMapping(value = "/newOrder")
    public String newOrder() {
        return "page/form";
    }
}