package com.flyin.example.config;

import com.flyin.example.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @author 王军
 * @description
 * @date 2021/12/29 13:51
 */
@Slf4j
@Configuration
public class RabbitConfig {
    public static final String EXCHANGE_NAME = "test-exchange";
    public static final String QUEUE_NAME = "test-queue";
    public static final String BINDING_KEY_NAME = "test-binding";

    @Bean
    public ConnectionFactory msgConnectionFactory(
            @Value("${spring.rabbitmq.host}") String host,
            @Value("${spring.rabbitmq.port}") int port,
            @Value("${spring.rabbitmq.username}") String username,
            @Value("${spring.rabbitmq.password}") String password,
            @Value("${spring.rabbitmq.virtual-host}") String vhost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(vhost);
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }

    @Bean(value = QUEUE_NAME)
    public Queue getQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean(value = EXCHANGE_NAME)
    public DirectExchange getExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingA1(@Qualifier(QUEUE_NAME) Queue queue,
                             @Qualifier(EXCHANGE_NAME) DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BINDING_KEY_NAME);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, RabbitTemplate.ReturnCallback returnCallback,RabbitTemplate.ConfirmCallback confirmCallback) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setReturnCallback(returnCallback);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        return rabbitTemplate;
    }

    @Bean
    public RabbitTemplate.ReturnCallback returnedMessage() {
        return (message, replyCode, replyText, exchange, routingKey) -> log.info("Received messageId {}", message.getMessageProperties().getMessageId());
    }

    @Bean
    public RabbitTemplate.ConfirmCallback confirmCallback(MessageProducer messageSender) {
        return (correlationData, ack, cause) -> {
            String msgId = Objects.requireNonNull(correlationData).getId();
            String msg = messageSender.dequeueUnAckMsg(msgId);
            if (ack) {
                log.info("消息 {} 成功发送给mq", msg);
            } else {
                log.info("消息 {} 发送mq失败", msg);
            }
        };
    }
}