package com.tsubasa.WarehouseSystem.util;

import java.util.LinkedList;
import java.util.List;

import com.tsubasa.WarehouseSystem.common.MenuConsts;
import com.tsubasa.WarehouseSystem.controller.vo.MenuVo;

public class UserMenu {
    public static List<MenuVo> adminMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单管理", MenuConsts.ORDER));
        menu.add(new MenuVo("用户管理", MenuConsts.USERMANAGER));
        return menu;
    }
    public static List<MenuVo> orderMangerMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单管理", MenuConsts.ORDER));
        return menu;
    }
    public static List<MenuVo> orderMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单管理", MenuConsts.ORDER));
        return menu;
    }
}