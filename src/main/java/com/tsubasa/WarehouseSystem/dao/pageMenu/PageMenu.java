package com.tsubasa.WarehouseSystem.dao.pageMenu;

import java.util.List;

import com.tsubasa.WarehouseSystem.vo.MenuVo;

public interface PageMenu {
    public List<MenuVo> adminMenu();
    public List<MenuVo> orderMangerMenu();
    public List<MenuVo> orderMenu();
}