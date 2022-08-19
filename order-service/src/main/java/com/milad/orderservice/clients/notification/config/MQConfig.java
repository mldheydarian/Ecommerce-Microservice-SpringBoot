package com.milad.orderservice.clients.notification.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MQConfig {

    public final static String QUEUE = "notification_queue";
    public static final String TOPIC_EXCHANGE = "notification_topic_exchange";
    public static final String ROUTINE_KEY = "notification_routine_key";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(TOPIC_EXCHANGE);

    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange)
    {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTINE_KEY) ;
    }

    @Bean
    public MessageConverter messageConverter(){
      return  new Jackson2JsonMessageConverter();
    }

    @Bean(name = "RabbitTemplate")
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate template=new RabbitTemplate(connectionFactory);
        template.setExchange(TOPIC_EXCHANGE);
        template.setMessageConverter(messageConverter());
        return template;
    }




}
