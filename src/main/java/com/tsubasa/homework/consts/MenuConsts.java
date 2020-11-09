package com.tsubasa.homework.consts;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MenuConsts {
    private final String[][] order = {{"入库订单", "/orderIn"}, {"出库订单", "/orderOut"}, {"退货订单", "/orderReturn"}};
    private final String[][] orderManage = {{"入库订单详情", "/orderInManger"}, {"出库订单详情", "/orderOutManage", }, {"退货订单", "/orderReturnManage"}};
    private final String[][] userManage = {{"管理员设置", "/adminManager"}, {"员工设置", "/staffManager"}};;
}