package com.tsubasa.WarehouseSystem.service;

import java.util.List;

import com.tsubasa.WarehouseSystem.controller.vo.MenuVo;

public interface PageMenuService {
    public List<MenuVo> adminMenu();
    public List<MenuVo> orderMangerMenu();
    public List<MenuVo> orderMenu();
}