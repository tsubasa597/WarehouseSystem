package com.tsubasa.WarehouseSystem.common;

import org.springframework.stereotype.Component;

@Component
public class MenuConsts {
    /**
     * TODO : 修改入库订单
     */
    public final static String[][] ORDER = {{"入库订单", "/page/table"}, {"出库订单", "/orderOut"}, {"退货订单", "/orderReturn"}};
    public final static String[][] ORDERMANAGE = {{"入库订单详情", "/orderInManger"}, {"出库订单详情", "/orderOutManage", }, {"退货订单详情", "/orderReturnManage"}};
    public final static String[][] USERMANAGER = {{"管理员设置", "/adminManager"}, {"员工设置", "/staffManager"}};;
}