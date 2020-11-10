package com.tsubasa.WarehouseSystem.dao.pageMenu.Impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.consts.MenuConsts;
import com.tsubasa.WarehouseSystem.dao.pageMenu.PageMenu;
import com.tsubasa.WarehouseSystem.vo.MenuVo;

import org.springframework.stereotype.Component;

@Component
public class PageMenuImpl implements PageMenu {
    @Resource
    private MenuConsts menuConsts;

    @Override
    public List<MenuVo> adminMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单", menuConsts.getORDER()));
        menu.add(new MenuVo("订单管理", menuConsts.getORDERMANAGE()));
        menu.add(new MenuVo("用户管理", menuConsts.getUSERMANAGER()));
        return menu;
    }
    @Override
    public List<MenuVo> orderMangerMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单", menuConsts.getORDER()));
        menu.add(new MenuVo("订单管理", menuConsts.getORDERMANAGE()));
        return menu;
    }
    @Override
    public List<MenuVo> orderMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单", menuConsts.getORDER()));
        return menu;
    }
}