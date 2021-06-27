package com.life.joker.common;

/**
 * @author zhengdeqi
 * @description 通用返回封装类
 * @date 2021/6/26
 */
public interface IErrorCode {

    /**
     * 错误码
     *
     * @return
     */
    String getCode();

    /**
     * 错误信息
     *
     * @return
     */
    String getMessage();
}
