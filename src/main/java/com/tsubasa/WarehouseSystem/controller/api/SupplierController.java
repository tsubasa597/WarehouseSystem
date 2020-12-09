package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.SupplierTableVo;
import com.tsubasa.WarehouseSystem.service.SupplierService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Resource
    private SupplierService supplierSerice;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<SupplierTableVo> select(@RequestParam int page, int limit) {
        return supplierSerice.getAll(page, limit);
    }

    @RequestMapping(value = "/deleteSupplier", method = RequestMethod.POST)
    public Result<Object> deleteSupplierById(@RequestParam int id) {
        return supplierSerice.deleteSupplierById(id);
    }
    
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public Result<SupplierTableVo> selectSupplierByName(@RequestParam int page, int limit, String name) {
        return supplierSerice.selectSupplierByName(page, limit, name);
    }

    @RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
    public Result<Object> updateSupperlier(SupplierTableVo supplierTableVo) {
        return supplierSerice.updateSupplier(supplierTableVo);
    }

    @RequestMapping(value = "/insertSupplier", method = RequestMethod.POST)
    public Result<Object> insertSupplier(SupplierTableVo tableVo) {
        return supplierSerice.insertSupplier(tableVo);
    }
}