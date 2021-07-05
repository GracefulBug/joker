package com.life.joker.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhengdeqi
 * @description 消息枚举
 * @date 2021/7/1
 */
@NoArgsConstructor
@AllArgsConstructor
public enum MessageEnum {

    ROUTTING_KEY();

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;
}
