package com.bai.SpringBootStudy.SpringBootStudy.config;

import com.bai.SpringBootStudy.SpringBootStudy.constant.RabConstant;
import com.bai.SpringBootStudy.SpringBootStudy.constant.RabbitConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitMqConfig
 * @Description: RabbitMQ配置
 * @Author  JavaZhan @公众号:Java全栈架构师
 * @Date 2020/6/12
 * @Version V1.0
 **/
@Slf4j
@Configuration
public class RabbitMqConfig {
    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause));
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message));
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

    /**
     * 队列
     * */
    @Bean
    public Queue testQueue() {
        return new Queue(RabbitConstant.TEST_QUEUE);
    }
    /**
     * 交换机
     * */
    @Bean
    public DirectExchange testExchange() {
        return new DirectExchange(RabbitConstant.TEST_QUEUE_KEE_EXCHANGE,
                true,
                false);
    }
    /**
     * 队列绑定路由和交换机
     * */
    @Bean
    public Binding taskOrderHandleBinding() {
        return BindingBuilder.bind(testQueue()).to(testExchange()).with(RabbitConstant.TEST_QUEUE_KEY);
    }

}

