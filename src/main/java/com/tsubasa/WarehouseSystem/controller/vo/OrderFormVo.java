package com.tsubasa.WarehouseSystem.controller.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderFormVo implements Serializable {
    private static final long serialVersionUID = 3L;

    private String goodsName;
    private int goodsNum;
    private int orderType;
    private String orderDate;
    private String orderUser;
    private int orderPrice;
}