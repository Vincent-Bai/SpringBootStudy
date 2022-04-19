package com.bai.SpringBootStudy.SpringBootStudy.utils;

import com.bai.SpringBootStudy.SpringBootStudy.constant.RabbitConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String str){
        rabbitTemplate.convertAndSend(RabbitConstant.TEST_QUEUE_KEE_EXCHANGE,RabbitConstant.TEST_QUEUE_KEY,str);
    }
}
