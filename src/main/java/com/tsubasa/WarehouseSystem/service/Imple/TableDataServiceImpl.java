package com.tsubasa.WarehouseSystem.service.Imple;

import java.util.List;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.dao.OrderDao;
import com.tsubasa.WarehouseSystem.entity.Order;
import com.tsubasa.WarehouseSystem.service.TableVoService;
import com.tsubasa.WarehouseSystem.util.BeanUtil;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.stereotype.Service;

/**
 * 展示在 Table 里的数据
 */
@Service
public class TableDataServiceImpl implements TableVoService {
    @Resource
    private OrderDao orderDao;

    @Override
    public Result<TableVo> putInOrder() {
        List<Order> order = orderDao.selectList(null);
        List<TableVo> tableVos = BeanUtil.copyList(order, TableVo.class);
        Result<TableVo> result = new Result<>();
        result.setCode(0);
        result.setMsg("");
        result.setData(tableVos);
        return result;
    }

    @Override
    public Result<TableVo> putInOrderByType(int orderType) {
        List<Order> order = orderDao.selectByType(orderType);
        List<TableVo> tableVos = BeanUtil.copyList(order, TableVo.class);
        Result<TableVo> result = new Result<>();
        result.setCode(0);
        result.setMsg("");
        result.setData(tableVos);
        return result;
    }

    @Override
    public Result<TableVo> putInOrderByState(int orderState) {
        List<Order> order = orderDao.selectByIsOrder(orderState);
        List<TableVo> tableVos = BeanUtil.copyList(order, TableVo.class);
        Result<TableVo> result = new Result<>();
        result.setCode(0);
        result.setMsg("");
        result.setData(tableVos);
        return result;
    }
}