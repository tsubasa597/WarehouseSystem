package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.service.TableDataService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TableDataController {
    /**
     * TODO: 添加过滤和搜索功能
     */
    @Resource
    private TableDataService tableDataService;

    @RequestMapping("/table")
    public Result<TableVo> table() {
        return tableDataService.putInOrder();
    }
}