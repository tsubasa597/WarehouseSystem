package com.tsubasa.WarehouseSystem.controller.vo;

import lombok.Data;

@Data
public class UserFormVo {
    private int userId;
    private String userName;
    private String userPwd;
    private int userSex;
    private int userAge;
    private String userPhone;
    private int userType;
}