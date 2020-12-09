package com.tsubasa.WarehouseSystem.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsubasa.WarehouseSystem.controller.vo.SupplierTableVo;
import com.tsubasa.WarehouseSystem.dao.SupplierDao;
import com.tsubasa.WarehouseSystem.entity.Supplier;
import com.tsubasa.WarehouseSystem.service.SupplierService;
import com.tsubasa.WarehouseSystem.util.BeanUtil;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierDao supplierDao;

    @Override
    public Result<SupplierTableVo> getAll(int page, int limit) {
        Page<Supplier> orderPage = new Page<>(page, limit);
        IPage<Supplier> iPage = supplierDao.selectPage(orderPage, new QueryWrapper<Supplier>());
        List<SupplierTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), SupplierTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<Object> deleteSupplierById(int id) {
        supplierDao.deleteById(id);
        return new Result<>(null, 0, "", 0);
    }

    @Override
    public Result<SupplierTableVo> selectSupplierByName(int page, int limit, String name) {
        Page<Supplier> orderPage = new Page<>(page, limit);
        IPage<Supplier> iPage = supplierDao.selectPage(orderPage, new QueryWrapper<Supplier>().eq("supplier_name", name));
        List<SupplierTableVo> tableVos = BeanUtil.copyList(iPage.getRecords(), SupplierTableVo.class);
        return new Result<>(tableVos, 0, "", iPage.getTotal());
    }

    @Override
    public Result<Object> updateSupplier(SupplierTableVo tableVo) {
        supplierDao.updateById(tableVo);
        return new Result<>(null, 0, "", 0);
    }

    @Override
    public Result<Object> insertSupplier(SupplierTableVo tableVo) {
        supplierDao.insert(tableVo);
        return new Result<>(null, 0, "", 0);
    }
}