package com.tsubasa.WarehouseSystem.common;

import org.springframework.stereotype.Component;

@Component
public class MenuConsts {
    public final static String[][] INORDER = {{"查看入库订单", "/main/orderManager/inOrder"}};
    public final static String[][] OUTORDER = {{"查看出库订单", "/main/orderManager/outOrder"}};
    public final static String[][] RETURNORDER = {{"查看退货订单", "/main/orderManager/returnOrder"}};
    public final static String[][] USERMANAGER = {{"仓库员工信息", "/main/staffManager"}, {"客户信息", "/main/customerManager"}, {"供货商信息", "/main/supplierManager"}};;
}