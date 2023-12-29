package com.me.assumentpark.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class EmployeeQueryDTO implements Serializable {
    private String name;
    private Integer minAge;
    private Integer maxAge;
    private Integer sex;
    private Integer status;
    private LocalDateTime minCreateTime;
    private LocalDateTime maxCreateTime;
    private Integer minSalary;
    private Integer maxSalary;
}
