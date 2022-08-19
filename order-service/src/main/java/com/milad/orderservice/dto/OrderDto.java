package com.milad.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderDto {


    private Long orderId;

    private LocalDateTime orderDate;

    private Double orderFee;

    private String status;

    private Long userId;


}
