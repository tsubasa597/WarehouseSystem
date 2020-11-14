package com.tsubasa.WarehouseSystem.common;

import org.springframework.stereotype.Component;

@Component
public class MenuConsts {
    public final static String[][] ORDER = {{"订单详情", "/orderManger"}, {"新建订单", "/newOrder"}};
    public final static String[][] USERMANAGER = {{"管理员管理", "/adminManager"}, {"员工管理", "/staffManager"}};;
}