package com.tsubasa.WarehouseSystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "db_users")
public class User {
    @TableId
    private String usersName;
    private String usersPwd;
    private int usersType; 
}