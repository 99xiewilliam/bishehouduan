package com.cad.demo.exception;

import com.cad.demo.common.RetResult;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class})
    public RetResult msgNotReadable(Exception e) {
        System.out.println(e.getMessage());
        return new RetResult(500, "请求参数不匹配");
    }

    @ExceptionHandler({NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class})
    public RetResult reqException(Exception e) {
        System.out.println(e);
        return new RetResult(404, "路径不存在");
    }


    //参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RetResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new RetResult(500, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(GlobalException.class)
    public RetResult handleGlobalException(GlobalException e) {
        return new RetResult(e.getCode(), e.getMsg());
    }
}
