package com.tsubasa.WarehouseSystem.common;

/**
 * Error Class
 * TODO : Remove File
 */
public enum OrderTypeEmnu {
    PUTINWAREHOUSE("入库"),
    OUTWAREHOUSE("出库"),
    RETURNGOODS("退货");

    private String result;

    private OrderTypeEmnu(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}