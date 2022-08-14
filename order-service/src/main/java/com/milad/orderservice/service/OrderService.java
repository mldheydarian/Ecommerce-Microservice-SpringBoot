package com.milad.orderservice.service;

import com.milad.orderservice.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    OrderDto save(OrderDto orderDto);
    OrderDto getOrderById(Long Id);
    List<OrderDto> getOrdersByUserId(Long userId);
    List<OrderDto> getOrders();
}
