package com.milad.orderservice.repository;

import com.milad.orderservice.dto.OrderDto;
import com.milad.orderservice.model.Order;
import com.milad.orderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {



}
