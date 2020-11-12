package com.tsubasa.WarehouseSystem.controller.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class TableVo implements Serializable {
    private static final long serialVersionUID = 2L;

    private String goodsName;
    private int goodsNum;
    private int isOrder;
    private int orderType;
}