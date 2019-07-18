package com.elfop.sulfur.base.excpetion;

import com.elfop.sulfur.base.common.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static com.elfop.sulfur.base.common.Dic.RESULT_CODE_CLIENT_FAIL;

/**
 * @Description: 统一异常处理
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/9  10:13
 */
@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = Throwable.class)
    public WebResult defaultErrorHandler(HttpServletRequest req, Throwable e) {
        log.error("全局异常拦截器  {}   请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return WebResult.failResult(e.getMessage());
    }

    @ExceptionHandler(value = SQLException.class)
    public WebResult sqlErrorHandler(HttpServletRequest req, SQLException e) {
        log.error("全局异常拦截器 sql语句异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return WebResult.failResult();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public WebResult methodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) {
        log.error("全局异常拦截器 请求参数校验不正确  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return WebResult.failResult(RESULT_CODE_CLIENT_FAIL, "请求参数校验不正确");
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public WebResult httpMessageNotReadableException(HttpServletRequest req, HttpMessageNotReadableException e) {
        log.error("全局异常拦截器 请求参数格式不正确  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return WebResult.failResult(RESULT_CODE_CLIENT_FAIL, "请求参数格式不正确");
    }

}
