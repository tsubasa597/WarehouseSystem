package com.tsubasa.WarehouseSystem.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}