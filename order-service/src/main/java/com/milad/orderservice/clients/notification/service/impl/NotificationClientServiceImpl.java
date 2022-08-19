package com.milad.orderservice.clients.notification.service.impl;

import com.milad.orderservice.clients.notification.config.MQConfig;
import com.milad.orderservice.clients.notification.dto.NotificationDto;
import com.milad.orderservice.clients.notification.service.NotificationClientService;
import com.milad.orderservice.dto.OrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationClientServiceImpl implements NotificationClientService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public String sendMassage(NotificationDto notificationDto) {

        rabbitTemplate.convertAndSend(
                MQConfig.TOPIC_EXCHANGE,
                MQConfig.ROUTINE_KEY,
                notificationDto);
        return "Massage published to Consumer";

    }

    @Override
    public String sendOrderRegisteredMessage(OrderDto dto) {

        NotificationDto notificationDto = NotificationDto.builder()
                .message("Your Order Was Registered Correctly")
                .sender("OrderService")
                .sentAt(new Date())
                .toUserId(dto.getUserId())
                .build();
        sendMassage(notificationDto);
        return "Your Order Was Registered Correctly";
    }

    @Override
    public String sendOrderPayedMessage(OrderDto dto) {

        return null;
    }

    @Override
    public String sendOrderPreparedMessage(OrderDto dto) {

      return null;
    }

    @Override
    public String sendOrderShippingMessage(OrderDto dto) {

        return null;
    }

    @Override
    public String sendOrderDeliveredMessage(OrderDto dto) {
        return null;
    }

}
