package com.atguigu.ssyx.common.result;

import lombok.Data;

/**
 * @author 韩跃迁
 * @date 2023年06月25日 下午 22:24
 */
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    private Result(){}


    //设置数据，返回对象的方法
    public static<T> Result<T> build(T data,ResultCodeEnum resultCodeEnum){
        Result<T> result = new Result<>();
        //判断返回结果中是否需要数据
        if (data != null){
            result.setData(data);
        }

        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());

        return result;

    }

    //成功的方法
    public static<T> Result<T> ok(T data){
        Result<T> result = build(data, ResultCodeEnum.SUCCESS);
        return result;
    }

    //失败的方法
    public static<T> Result<T> fail(T data){
        Result<T> result = build(data, ResultCodeEnum.FAIL);
        return result;
    }

}
