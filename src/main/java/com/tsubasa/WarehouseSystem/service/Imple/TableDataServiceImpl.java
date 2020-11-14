package com.tsubasa.WarehouseSystem.service.Imple;

import java.util.List;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.dao.OrderDao;
import com.tsubasa.WarehouseSystem.entity.Order;
import com.tsubasa.WarehouseSystem.service.TableDataService;
import com.tsubasa.WarehouseSystem.util.BeanUtil;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.stereotype.Service;

@Service
public class TableDataServiceImpl implements TableDataService {
    @Resource
    private OrderDao orderDao;

    @Override
    public Result<TableVo> putInOrder() {
        List<Order> order = orderDao.selectList(null);
        // BeanUtils.copyProperties(order, tableVos);
        List<TableVo> tableVos = BeanUtil.copyList(order, TableVo.class);
        Result<TableVo> result = new Result<>();
        result.setCode(0);
        result.setMsg("");
        result.setData(tableVos);
        return result;
    }
}