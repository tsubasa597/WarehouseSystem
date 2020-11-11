package com.tsubasa.WarehouseSystem.controller.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class MenuVo implements Serializable {
    // 指定 serialVersionUID
    private static final long serialVersionUID = 1L;
    private String menuName;
    private String[][] menuChildren;
    
    public MenuVo(String menuName, String[][] menuChildren) {
        this.setMenuName(menuName);
        this.setMenuChildren(menuChildren);
    }
}