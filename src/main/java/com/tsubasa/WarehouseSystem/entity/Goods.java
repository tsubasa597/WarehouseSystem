package com.tsubasa.WarehouseSystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * TODO : 修改字段
 */

@Data
@TableName(value = "db_goods")
public class Goods {
    @TableId
    private int goodsId;
    private String goodsName;
    private int goodsNum;
    private int goodsPrice;
}