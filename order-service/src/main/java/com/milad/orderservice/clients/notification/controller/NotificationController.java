package com.milad.orderservice.clients.notification.controller;


import com.milad.orderservice.clients.notification.dto.NotificationDto;
import com.milad.orderservice.clients.notification.service.impl.NotificationClientServiceImpl;
import com.milad.orderservice.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {


    @Autowired
    NotificationClientServiceImpl notificationClientService;

    @PostMapping("")
    public String sendMassage(@RequestBody NotificationDto notificationDto) {

        notificationClientService.sendMassage(notificationDto);
        return "Massage puplished to Consumer";

    }

    @PostMapping("/orderregistered")
    public String sendOrderRegisteredMessage(@RequestBody OrderDto orderDto) {

        return notificationClientService.sendOrderRegisteredMessage(orderDto);

    }
    public String sendOrderPayedMessage(OrderDto dto) {return null;}
    public String sendOrderPreparedMessage(OrderDto dto){return null;}
    public String sendOrderShippingMessage(OrderDto dto){return null;}
    public String sendOrderDeliveredMessage(OrderDto dto) {return null;}

}
