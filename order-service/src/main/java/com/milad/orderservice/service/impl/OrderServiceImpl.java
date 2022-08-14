package com.milad.orderservice.service.impl;

import com.milad.orderservice.dto.OrderDto;
import com.milad.orderservice.dto.mapper.OrderMapping;
import com.milad.orderservice.exception.wrapper.OrderNotFoundException;
import com.milad.orderservice.repository.OrderRepository;
import com.milad.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;


    @Override
    public OrderDto save(OrderDto orderDto) {

        return OrderMapping.getDto(
                orderRepository.save(OrderMapping.getEntity(orderDto)));

    }

    @Override
    public OrderDto getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(OrderMapping::getDto)
                .orElseThrow(()-> new OrderNotFoundException("Order Not Found Dadash"));

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
