package com.life.joker.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zhengdeqi
 * @description RabbitMQ 配置
 * @date 2021/7/1
 */
@Configuration
public class RabbitMqConfig {

    @Value("${joker.rabbitmq.host}")
    private String addresses;

    @Value("${joker.rabbitmq.port}")
    private String port;

    @Value("${joker.rabbitmq.username}")
    private String username;

    @Value("${joker.rabbitmq.password}")
    private String password;

    @Value("${joker.rabbitmq.virtual-host}")
    private String virtualHost;


    @Bean(name = "jokerConnectionFactory")
    public ConnectionFactory connectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses + ":" + port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);

        return connectionFactory;
    }

    /**
     * 必须是prototype类型
     *
     * @param connectionFactory
     * @return
     */
    @Bean(name = "jokerRabbitTemplate")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(@Qualifier("jokerConnectionFactory") ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
        template.setMessageConverter(jsonMessageConverter);
        return template;
    }
}
