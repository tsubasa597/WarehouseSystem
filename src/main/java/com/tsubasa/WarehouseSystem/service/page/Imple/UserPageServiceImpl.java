package com.tsubasa.WarehouseSystem.service.page.Imple;

import java.util.List;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.dao.pageMenu.Impl.PageMenuImpl;
import com.tsubasa.WarehouseSystem.service.page.UserPageService;
import com.tsubasa.WarehouseSystem.vo.MenuVo;

import org.springframework.stereotype.Service;

@Service
public class UserPageServiceImpl implements UserPageService {
    @Resource
    private PageMenuImpl pageMenu;

    @Override
    public List<MenuVo> addMenu() {
        return pageMenu.adminMenu();
    }
}