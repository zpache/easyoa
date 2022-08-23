package com.zpache.common.exception;

import com.zpache.common.result.Result;
import com.zpache.common.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2022/8/24 00:14
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    public Result unifiedException(HttpServletRequest request, Exception e) {
        log.error("<全局异常><异常处理><异常信息：{}>", e.getMessage(), e);
        if (e instanceof ServiceException) {
            return ResultUtils.error("1000", e.getMessage());
        }else if (e instanceof HttpRequestMethodNotSupportedException) {
            return ResultUtils.error(e.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            FieldError fieldError = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError();
            return ResultUtils.error(fieldError == null ? "参数缺失" : fieldError.getDefaultMessage());
        } else if (e instanceof HttpMessageNotReadableException) {
            return ResultUtils.error("请求体缺失");
        }
        return ResultUtils.error();
    }
}
