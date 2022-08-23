package com.zpache.common.utils;

import com.zpache.common.result.Result;

/**
 * @desc:
 * @author: wang bing
 * @createTime: 2022/8/24 00:03
 */
public class ResultUtils {

    public static Result success() {
        Result result = new Result();
        result.setCode("0");
        result.setMessage("成功");
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode("0");
        result.setMessage("成功");
        result.setData(data);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode("-1");
        result.setMessage("网络异常，请稍后再试");
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.setCode("-1");
        result.setMessage(message);
        return result;
    }

    public static Result error(String code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
