package com.tsubasa.WarehouseSystem.service.Imple;

import java.util.List;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.dao.OrderDao;
import com.tsubasa.WarehouseSystem.entity.Order;
import com.tsubasa.WarehouseSystem.service.TableDataService;
import com.tsubasa.WarehouseSystem.util.BeanUtil;

import org.springframework.stereotype.Service;

@Service
public class TableDataServiceImpl implements TableDataService {
    @Resource
    private OrderDao orderDao;

    @Override
    public List<TableVo> putInOrder() {
        List<Order> order = orderDao.selectList(null);
        List<TableVo> tableVos = BeanUtil.copyList(order, TableVo.class);
        BeanUtil.copyProperties(order, tableVos);
        return tableVos;
    }
}