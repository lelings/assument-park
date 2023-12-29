package com.me.assumentpark.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Result() {this.code = 200;}

    public Result(Integer code,T data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result ok() {
        return new Result();
    }

    public static Result ok(Object data) {
        Result result = new Result();
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static Result error(Integer code,String msg) {
        Result result = new Result(code,msg);
        return result;
    }
}
