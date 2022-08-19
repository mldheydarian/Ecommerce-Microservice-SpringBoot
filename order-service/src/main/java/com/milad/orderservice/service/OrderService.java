package com.milad.orderservice.service;

import com.milad.orderservice.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    OrderDto save(OrderDto orderDto, Map<String, String> headers);
    OrderDto getOrderById(Long Id);
    List<OrderDto> getOrdersByUserId(Long userId);
    List<OrderDto> getOrders();
}
