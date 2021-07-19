package com.life.joker.mq.consumer;

import com.life.joker.enums.QueueEnum;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

/**
 * @author zhengdeqi
 * @description 消息消费者
 * @date 2021/7/19
 */
@Slf4j
@Component
public class MQConsumer {

    @RabbitListener(queues = {"joker.q1"})
    @RabbitHandler
    public void consumer1(Message message, Channel channel) {
        try {
            String strObject = new String(message.getBody(), "UTF-8");
            log.info("consumer1--消息接受成功！时间：【{}】，消息体--【{}】", LocalDateTime.now(), strObject);
            if (StringUtils.isNoneBlank(strObject) && strObject.contains("dasda")) {
                log.info("consumer1--消息接受成功！但不消费--重新入队");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
                return;
            }
            try {
                //设置消费者的 ack 模式为手动确认模式
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
                log.info("消费失败，请查看原因: {}", e.getCause());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("消息转码失败，请查看原因", e.getCause());
        }
    }

    @RabbitListener(queues = {"joker.q1"})
    @RabbitHandler
    public void consumer2(Message message, Channel channel) {
        try {
            String strObject = new String(message.getBody(), "UTF-8");
            log.info("consumer2--消息接受成功！时间：【{}】，消息体--【{}】", LocalDateTime.now(), strObject);
            if (StringUtils.isNoneBlank(strObject) && strObject.contains("dasda")) {
                log.info("consumer2--消息接受成功！但不消费--重新入队");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, true);
                return;
            }

            try {
                //设置消费者的 ack 模式为手动确认模式
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
                log.info("消费失败，请查看原因: {}", e.getCause());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("消息转码失败，请查看原因", e.getCause());
        }
    }
}
