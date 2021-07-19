package com.life.joker.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhengdeqi
 * @description 消息队列枚举
 * @date 2021/7/13
 */
@Getter
@AllArgsConstructor
public enum QueueEnum {

    /**
     * 消息通知队列
     */
    QUEUE_TEST_1("joker.direct.ex1", "joker.q1", "joker.1"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;

    /**
     * 队列名称
     */
    private String name;

    /**
     * 路由键
     */
    private String routeKey;

    /**
     * 获取队列名称
     *
     * @param queueEnum
     * @return
     */
    public static String getQueueName(QueueEnum queueEnum) {
        return queueEnum.getName();
    }

}
