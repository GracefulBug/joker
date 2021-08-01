package com.life.joker.mq.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.life.joker.enums.QueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengdeqi
 * @description 消息生产者
 * @date 2021/7/19
 */
@Slf4j
@Component
public class MQProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * 发送消息
     *
     * @param queueEnum
     * @param object
     */
    public void sendMessage(QueueEnum queueEnum, Object object) {
        try {
            Message message = MessageBuilder
                    .withBody(objectMapper.writeValueAsBytes(object))
                    .build();
            rabbitTemplate.convertAndSend(queueEnum.getExchange(), queueEnum.getRouteKey(), message);
        } catch (Exception e) {
            log.error("发送消息异常--交换机--{}，路由键--{}, 消息体--{}", queueEnum.getExchange(), queueEnum.getRouteKey(), object.toString());
        }
    }
}
