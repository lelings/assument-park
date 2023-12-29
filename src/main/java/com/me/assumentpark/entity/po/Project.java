package com.me.assumentpark.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Project implements Serializable {
    private Integer id;
    private String name;
    private Integer price;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Integer maxSize;
    /**
     * 0表示不运营，1表示运营
     */
    private Integer status;
    private String description;
}
