package com.tsubasa.WarehouseSystem.service;

import java.util.Map;

import com.tsubasa.WarehouseSystem.entity.User;

public interface LoginService {
    public User login(Map<String, String> info);
}