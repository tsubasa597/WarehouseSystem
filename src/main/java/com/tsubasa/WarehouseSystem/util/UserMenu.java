package com.tsubasa.WarehouseSystem.util;

import java.util.LinkedList;
import java.util.List;

import com.tsubasa.WarehouseSystem.common.MenuConsts;
import com.tsubasa.WarehouseSystem.controller.vo.MenuVo;

public class UserMenu {
    public static List<MenuVo> adminMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("入库管理", MenuConsts.INORDER));
        menu.add(new MenuVo("出库管理", MenuConsts.OUTORDER));
        menu.add(new MenuVo("退货信息管理", MenuConsts.RETURNORDER));
        menu.add(new MenuVo("基本信息管理", MenuConsts.USERMANAGER));
        return menu;
    }
    public static List<MenuVo> orderMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("入库管理", MenuConsts.INORDER));
        menu.add(new MenuVo("出库管理", MenuConsts.OUTORDER));
        menu.add(new MenuVo("退货信息管理", MenuConsts.RETURNORDER));
        return menu;
    }
}