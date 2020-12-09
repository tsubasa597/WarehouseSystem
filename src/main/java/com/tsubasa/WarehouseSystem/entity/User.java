package com.tsubasa.WarehouseSystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "db_users")
public class User {
    @TableId
    private int userId;
    private String userName;
    private String userPwd;
    private int userAge;
    private int userSex;
    private String userPhone;
    private int userType; 
}