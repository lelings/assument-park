package com.me.assumentpark.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {
    private Integer id;
    private String name;
    private String phone;
    private String password;
    private Integer age;
    private Integer sex;
    private Integer salary;
}
