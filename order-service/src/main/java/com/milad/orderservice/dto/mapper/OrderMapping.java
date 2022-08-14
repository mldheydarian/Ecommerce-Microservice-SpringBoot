package com.milad.orderservice.dto.mapper;

import com.milad.orderservice.dto.OrderDto;
import com.milad.orderservice.model.Order;

public class OrderMapping {

   public static OrderDto getDto(Order order){

       return new OrderDto()
               .setOrderId(order.getOrderId())
               .setOrderDate(order.getOrderDate())
               .setOrderFee(order.getOrderFee())
               .setStatus(order.getStatus())
               .setUserId(order.getUserId());

   }


   public  static Order getEntity(OrderDto orderDto)
    {
        return new Order()
                .setOrderId(orderDto.getOrderId())
                .setOrderDate(orderDto.getOrderDate())
                .setOrderFee(orderDto.getOrderFee())
                .setStatus(orderDto.getStatus())
                .setUserId(orderDto.getUserId());

    }
}
