package com.tsubasa.WarehouseSystem.controller.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class FormVo implements Serializable {
    private static final long serialVersionUID = 3L;
    
    private String orderDescribe;
    private String goodsName;
    private int goodsNum;
    private int orderType;
}