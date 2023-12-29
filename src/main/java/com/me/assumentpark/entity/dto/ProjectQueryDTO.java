package com.me.assumentpark.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProjectQueryDTO implements Serializable {
    private String name;
    private Integer minPrice;
    private Integer maxPrice;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Integer maxSize;
    private Integer status;
}
