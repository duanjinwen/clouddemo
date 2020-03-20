package com.cesgroup.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Duan.jw
 * @create: 2020/3/18 11:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;


    public Result(Integer code, String message) {
        this(code, message, null);
    }
}
