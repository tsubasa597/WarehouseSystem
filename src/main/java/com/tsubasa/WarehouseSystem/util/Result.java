package com.tsubasa.WarehouseSystem.util;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 3L;
    private List<T> data;
    private int code;
    private String msg;
    private int count;
}