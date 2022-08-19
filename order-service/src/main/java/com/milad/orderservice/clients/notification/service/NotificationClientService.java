package com.milad.orderservice.clients.notification.service;

import com.milad.orderservice.dto.OrderDto;
import org.springframework.stereotype.Service;

@Service
public interface NotificationClientService {

     String sendOrderRegisteredMessage(OrderDto dto) ;
     String sendOrderPayedMessage(OrderDto dto) ;
     String sendOrderPreparedMessage(OrderDto dto) ;
     String sendOrderShippingMessage(OrderDto dto) ;
     String sendOrderDeliveredMessage(OrderDto dto) ;
}
