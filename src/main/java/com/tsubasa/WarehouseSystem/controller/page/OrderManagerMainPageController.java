package com.tsubasa.WarehouseSystem.controller.page;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.tsubasa.WarehouseSystem.service.OrderService;
import com.tsubasa.WarehouseSystem.util.UserMenu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class OrderManagerMainPageController {
    @Resource
    private OrderService tableDataService;

    @RequestMapping(value = "")
    public String test(Model model, HttpSession httpSession) {
        /**
         * TODO : 修改 Tests, side.html
         */
        if (httpSession.getAttribute("type").equals(0)) {
            model.addAttribute("tests", UserMenu.adminMenu());
        } else {
            model.addAttribute("tests", UserMenu.orderMenu());
        }
        return "/main";
    }

    @RequestMapping(value = "/orderManager/inOrder")
    public String inOrderManager() {
        return "page/orderManager/orderInTable";
    }

    @RequestMapping(value = "/orderManager/outOrder")
    public String outOrderManager() {
        return "page/orderManager/orderOutTable";
    }

    @RequestMapping(value = "/orderManager/returnOrder")
    public String returnOrderManager() {
        return "page/orderManager/orderReturnTable";
    }

    @RequestMapping(value = "/orderManager")
    public String orderManager() {
        return "page/orderManager/orderTable";
    }

    @RequestMapping(value = "/newOrder")
    public String newOrder(String orderType, Model model) {
        model.addAttribute("orderType", orderType);
        return "page/orderManager/orderForm";
    }


}