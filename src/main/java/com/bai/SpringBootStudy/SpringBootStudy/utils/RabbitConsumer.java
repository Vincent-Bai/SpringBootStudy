package com.bai.SpringBootStudy.SpringBootStudy.utils;

import com.bai.SpringBootStudy.SpringBootStudy.constant.RabbitConstant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {


   /* @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitConstant.TEST_QUEUE),
            key = RabbitConstant.TEST_QUEUE_KEY,
            exchange = @Exchange(value = RabbitConstant.TEST_QUEUE_KEE_EXCHANGE)
    ))
    @RabbitHandler()
    public void getMsg(String messageBody, Message message, Channel channel) throws Exception {
        System.out.println(messageBody);
    }*/

}
