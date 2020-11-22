package com.tsubasa.WarehouseSystem.service.Imple;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsubasa.WarehouseSystem.controller.vo.FormVo;
import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.dao.OrderDao;
import com.tsubasa.WarehouseSystem.entity.Order;
import com.tsubasa.WarehouseSystem.service.OrderService;
import com.tsubasa.WarehouseSystem.util.BeanUtil;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 展示在 Table 里的数据
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public Result<TableVo> putInOrder(int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, null);
        List<TableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), TableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<TableVo> putInOrderByType(int orderType, int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, new QueryWrapper<Order>().eq("order_type", orderType));
        List<TableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), TableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<TableVo> putInOrderByState(int orderState, int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, new QueryWrapper<Order>().eq("is_order", orderState));
        List<TableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), TableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<TableVo> putInOrderByGoodsName(String goodsName, int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, new QueryWrapper<Order>().eq("goods_name", goodsName));
        List<TableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), TableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<Object> newOrder(FormVo formVo) {
        Order order = new Order();
        BeanUtils.copyProperties(formVo, order);
        orderDao.insert(order);
        return new Result<>(null, 0, "", 0);
    }
}