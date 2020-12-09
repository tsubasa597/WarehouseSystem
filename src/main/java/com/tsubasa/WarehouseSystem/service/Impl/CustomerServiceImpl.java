package com.tsubasa.WarehouseSystem.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsubasa.WarehouseSystem.controller.vo.CustomerTableVo;
import com.tsubasa.WarehouseSystem.dao.CustomerDao;
import com.tsubasa.WarehouseSystem.entity.Customer;
import com.tsubasa.WarehouseSystem.service.CustomerService;
import com.tsubasa.WarehouseSystem.util.BeanUtil;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Override
    public Result<CustomerTableVo> getAll(int page, int limit) {
        Page<Customer> orderPage = new Page<Customer>(page, limit);
        IPage<Customer> iPage = customerDao.selectPage(orderPage, null);
        List<CustomerTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), CustomerTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }
    
    @Override
    public Result<CustomerTableVo> selectCustomerByName(int page, int limit, String name) {
        Page<Customer> orderPage = new Page<Customer>(page, limit);
        IPage<Customer> iPage = customerDao.selectPage(orderPage, new QueryWrapper<Customer>().eq("customer_name", name));
        List<CustomerTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), CustomerTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }
    @Override
    public Result<Object> deleteCustomerById(int id) {
        customerDao.deleteById(id);
        return new Result<>(null, 0, "", 0);
    }
    @Override
    public Result<Object> updateCustomer(CustomerTableVo tableVo) {
        customerDao.updateById(tableVo);
        return new Result<>(null, 0, "", 0);
    }
    @Override
    public Result<Object> insertCustomer(CustomerTableVo tableVo) {
        customerDao.insert(tableVo);
        return new Result<>(null, 0, "", 0);
    }
}