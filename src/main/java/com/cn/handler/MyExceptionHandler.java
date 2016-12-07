package com.cn.handler;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller的统一异常处理类
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> errorHandler(HttpServletRequest req, Exception e) throws Exception{
        e.printStackTrace();
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return  r;
    }
}
class ErrorInfo<T>{
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private Integer code;
    private String message;
    @JSONField(serialize = false)
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
