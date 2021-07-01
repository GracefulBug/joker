package com.life.joker.service;

/**
 * @author zhengdeqi
 * @description 消息Service
 * @date 2021/7/1
 */
public interface MessageService {

    /**
     * 发送消息
     *
     * @param exchange   交换机名称
     * @param routingKey 路由键
     * @param message    消息
     */
    void sendMessage(String exchange, String routingKey, Object message);

}
