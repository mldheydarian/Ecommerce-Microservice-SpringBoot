package com.milad.orderservice.service.impl;

import com.milad.orderservice.dto.OrderDto;
import com.milad.orderservice.dto.mapper.OrderMapping;
import com.milad.orderservice.exception.wrapper.OrderNotFoundException;
import com.milad.orderservice.repository.OrderRepository;
import com.milad.orderservice.clients.notification.service.impl.NotificationClientServiceImpl;
import com.milad.orderservice.clients.user.service.UserClientService;
import com.milad.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserClientService userClientService;

    @Autowired
    NotificationClientServiceImpl notificationClientService;

    @Override
    public OrderDto save(OrderDto orderDto, Map<String, String> headers) {

        Long userId = userClientService.getUserByUserNameInHttpHeader(headers).getBody().getUserId();
        //or
        //Long userId=userClientService.getUserByUserNameInQueryParam(headers.get("username")).getBody().getUserId();

        orderDto.setUserId(userId);
        try {
            OrderDto dto = OrderMapping.getDto(
            orderRepository.save(OrderMapping.getEntity(orderDto)));
            notificationClientService.sendOrderRegisteredMessage(orderDto);
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        //TODO:Correct return value
    }

    @Override
    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(OrderMapping::getDto)
                .orElseThrow(() -> new OrderNotFoundException("Order Not Found Dadash"));

    }

    @Override
    public List<OrderDto> getOrdersByUserId(Long userId) {

        return orderRepository.findByUserId(userId)
                .stream()
                .map(OrderMapping::getDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderDto> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapping::getDto)
                .collect(Collectors.toList());
    }


}
