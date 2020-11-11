package com.tsubasa.WarehouseSystem.service.Imple;

import java.util.LinkedList;
import java.util.List;

import com.tsubasa.WarehouseSystem.common.MenuConsts;
import com.tsubasa.WarehouseSystem.controller.vo.MenuVo;
import com.tsubasa.WarehouseSystem.service.PageMenuService;

import org.springframework.stereotype.Service;

@Service
public class PageMenuServiceImpl implements PageMenuService {

    @Override
    public List<MenuVo> adminMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单", MenuConsts.ORDER));
        menu.add(new MenuVo("订单管理", MenuConsts.ORDERMANAGE));
        menu.add(new MenuVo("用户管理", MenuConsts.USERMANAGER));
        return menu;
    }
    @Override
    public List<MenuVo> orderMangerMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单", MenuConsts.ORDER));
        menu.add(new MenuVo("订单管理", MenuConsts.ORDERMANAGE));
        return menu;
    }
    @Override
    public List<MenuVo> orderMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单", MenuConsts.ORDER));
        return menu;
    }
}