package com.cad.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private Integer code;
    private String msg;

//    public GlobalException(Integer code, String msg) {
//        this.code = code;
//        this.msg = msg;
//    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
