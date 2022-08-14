package com.milad.orderservice.dto;

import com.milad.orderservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {


    private Long orderItemId;

    private Order order;

    private Long procuctId;

    private Integer quantity;


}
