package com.tsubasa.WarehouseSystem.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsubasa.WarehouseSystem.controller.vo.OrderFormVo;
import com.tsubasa.WarehouseSystem.controller.vo.OrderTableVo;
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
    public Result<OrderTableVo> selectOrder(int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, null);
        List<OrderTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), OrderTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<OrderTableVo> selectOrderByType(int orderType, int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, new QueryWrapper<Order>().eq("order_type", orderType));
        List<OrderTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), OrderTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<OrderTableVo> selectOrderByState(int orderState, int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, new QueryWrapper<Order>().eq("is_order", orderState));
        List<OrderTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), OrderTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<OrderTableVo> selectOrderByGoodsName(String goodsName, int page, int limit) {
        Page<Order> orderPage = new Page<Order>(page, limit);
        IPage<Order> iPage = orderDao.selectPage(orderPage, new QueryWrapper<Order>().eq("goods_name", goodsName));
        List<OrderTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), OrderTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<Object> insertOrder(OrderFormVo formVo) {
        Order order = new Order();
        BeanUtils.copyProperties(formVo, order);
        orderDao.insert(order);
        return new Result<>(null, 0, "", 0);
    }
    /**
     * TODO : 判空，返回错误信息
     */
    @Override
    public Result<Object> deleteOrderById(int id) {
        orderDao.deleteById(id);
        return new Result<>(null, 0, "", 0);
    }

    /**
     * TODO : 判空，返回错误信息
     */
    @Override
    public Result<Object> updateOrderById(OrderTableVo tableVo) {
        Order order = new Order();
        BeanUtils.copyProperties(tableVo, order);
        orderDao.updateById(order);
        return new Result<>(null, 0, "", 0);
    }
}