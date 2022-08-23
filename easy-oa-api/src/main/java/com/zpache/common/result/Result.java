package com.zpache.common.result;

import lombok.Data;

/**
 * @desc:
 * @author: wang bing
 * @createTime: 2022/8/24 00:02
 */
@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;
}
