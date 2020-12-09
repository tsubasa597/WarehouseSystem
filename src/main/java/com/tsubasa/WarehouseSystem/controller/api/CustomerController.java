package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.CustomerTableVo;
import com.tsubasa.WarehouseSystem.service.CustomerService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<CustomerTableVo> getAll(@RequestParam int page, int limit, String name) {
        return customerService.getAll(page, limit);
    }
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    public Result<Object> deleteSupplierById(@RequestParam int id) {
        return customerService.deleteCustomerById(id);
    }
    
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public Result<CustomerTableVo> selectSupplierByName(@RequestParam int page, int limit, String name) {
        return customerService.selectCustomerByName(page, limit, name);
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public Result<Object> updateSupperlier(CustomerTableVo supplierTableVo) {
        return customerService.updateCustomer(supplierTableVo);
    }

    @RequestMapping(value = "/insertCustomer", method = RequestMethod.POST)
    public Result<Object> insertSupplier(CustomerTableVo tableVo) {
        return customerService.insertCustomer(tableVo);
    }
}