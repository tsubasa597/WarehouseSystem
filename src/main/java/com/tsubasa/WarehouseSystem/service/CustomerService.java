package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.controller.vo.CustomerTableVo;
import com.tsubasa.WarehouseSystem.util.Result;

public interface CustomerService {
    public Result<CustomerTableVo> getAll(int page, int limit);
    public Result<Object> deleteCustomerById(int id);
    public Result<CustomerTableVo> selectCustomerByName(int page, int limit, String name);
    public Result<Object> updateCustomer(CustomerTableVo tableVo);
    public Result<Object> insertCustomer(CustomerTableVo tableVo);
}