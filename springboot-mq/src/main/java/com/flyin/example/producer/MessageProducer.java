package com.flyin.example.producer;

import com.flyin.example.config.RabbitConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 王军
 * @description
 * @date 2021/12/29 14:36
 */
@Component
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public final Map<String, String> unAckMsgQueue = new ConcurrentHashMap<>();

    public void convertAndSend(String message) {
        String msgId = UUID.randomUUID().toString();
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(msgId);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.BINDING_KEY_NAME, message, correlationData);
        unAckMsgQueue.put(msgId, message);
    }

    public String dequeueUnAckMsg(String msgId) {
        return unAckMsgQueue.remove(msgId);
    }
}