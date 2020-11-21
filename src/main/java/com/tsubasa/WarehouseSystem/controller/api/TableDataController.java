package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.FormVo;
import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.service.TableVoService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TableDataController {
    /**
     * TODO: 添加搜索功能
     */
    @Resource
    private TableVoService tableDataService;

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public Result<TableVo> tableData() {
        return tableDataService.putInOrder();
    }

    @RequestMapping(value = "/table/type", method = RequestMethod.GET)
    public Result<TableVo> tableType(int type) {
        return tableDataService.putInOrderByType(type);
    }
    
    @RequestMapping(value = "/table/state", method = RequestMethod.GET)
    public Result<TableVo> tableState(int state) {
        return tableDataService.putInOrderByState(state);
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public Result<Null> from(FormVo formVo) {
        /**
         * TODO: 增加判断条件， 是否加入数据库
         */
        return null;
    }
}