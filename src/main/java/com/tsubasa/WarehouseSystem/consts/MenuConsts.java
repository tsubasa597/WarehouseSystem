package com.tsubasa.WarehouseSystem.consts;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MenuConsts {
    /**
     * TODO : 修改入库订单
     */
    private final String[][] ORDER = {{"入库订单", "/page/table"}, {"出库订单", "/orderOut"}, {"退货订单", "/orderReturn"}};
    private final String[][] ORDERMANAGE = {{"入库订单详情", "/orderInManger"}, {"出库订单详情", "/orderOutManage", }, {"退货订单详情", "/orderReturnManage"}};
    private final String[][] USERMANAGER = {{"管理员设置", "/adminManager"}, {"员工设置", "/staffManager"}};;
}