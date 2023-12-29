package com.me.assumentpark.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private Integer salary;
    private Integer age;
    private Integer sex;
    private LocalDateTime createTime;
}
