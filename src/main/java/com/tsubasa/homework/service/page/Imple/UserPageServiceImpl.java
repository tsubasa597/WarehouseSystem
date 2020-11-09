package com.tsubasa.homework.service.page.Imple;

import java.util.LinkedList;
import java.util.List;

import com.tsubasa.homework.consts.MenuConsts;
import com.tsubasa.homework.service.page.UserPageService;
import com.tsubasa.homework.vo.MenuVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPageServiceImpl implements UserPageService {
    @Autowired
    private MenuConsts consts;

    @Override
    public List<MenuVo> addMenu() {
        List<MenuVo> menu = new LinkedList<>();
        menu.add(new MenuVo("订单", consts.getOrder()));
        menu.add(new MenuVo("订单管理", consts.getOrderManage()));
        menu.add(new MenuVo("用户管理", consts.getUserManage()));
        return menu;
    }
}