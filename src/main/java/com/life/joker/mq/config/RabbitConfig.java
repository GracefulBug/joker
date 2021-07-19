package com.life.joker.mq.config;

import com.life.joker.enums.QueueEnum;
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengdeqi
 * @description 消息队列初始化
 * @date 2021/7/19
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue test1Queue() {
        return new Queue(QueueEnum.QUEUE_TEST_1.getName());
    }

    @Bean
    public FanoutExchange test1Exchange() {
        return new FanoutExchange(QueueEnum.QUEUE_TEST_1.getExchange());
    }

    @Bean
    public Binding test1Binding(FanoutExchange test1Exchange, Queue test1Queue) {
        return BindingBuilder.bind(test1Queue).to(test1Exchange);
    }
}
