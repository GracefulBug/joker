package com.life.joker.service.impl;

import com.life.joker.service.MessageService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author zhengdeqi
 * @description 消息Service实现类
 * @date 2021/7/1
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息内部记录日志信息，方便排查
     *
     * @param exchange   交换机名称
     * @param routingKey 路由键
     * @param message    消息
     */
    @Override
    public void sendMessage(String exchange, String routingKey, Object message) {
        
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationId);
    }
}
