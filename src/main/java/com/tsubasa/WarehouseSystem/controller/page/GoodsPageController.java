package com.tsubasa.WarehouseSystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class GoodsPageController {
    @RequestMapping("/goodsManager")
    public String goods() {
        return "/page/goodsManager/goodsTable";
    }
    @RequestMapping("/newGoods")
    public String newGoods() {
        return "/page/goodsManager/goodsForm";
    }
}