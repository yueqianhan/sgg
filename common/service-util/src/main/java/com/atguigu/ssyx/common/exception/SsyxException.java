package com.atguigu.ssyx.common.exception;

import com.atguigu.ssyx.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author 韩跃迁
 * @date 2023年06月27日 下午 21:43
 */
@Data
public class SsyxException extends RuntimeException{

    //异常状态码
    private Integer code;


    /**
     * 通过状态码和错误信息创建异常对象
     * @param message
     * @param code
     */
    public SsyxException(String message,Integer code){
        super(message);
        this.code = code;
    }


    /**
     * 接收枚举类对象
     * @param resultCodeEnum
     */
    public SsyxException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }


}
