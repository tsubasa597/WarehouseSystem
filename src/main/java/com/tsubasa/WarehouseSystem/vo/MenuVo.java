package com.tsubasa.WarehouseSystem.vo;

import lombok.Data;

@Data
public class MenuVo {
    private String menuName;
    private String[][] menuChildren;
    
    public MenuVo(String menuName, String[][] menuChildren) {
        this.setMenuName(menuName);
        this.setMenuChildren(menuChildren);
    }
}