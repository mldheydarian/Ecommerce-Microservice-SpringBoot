package com.milad.paymentservice.dto;

import com.milad.paymentservice.model.PaymentStatus;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PaymentDto implements Serializable {
    private final Long paymentId;
    private final Integer orderId;
    private final PaymentStatus paymentStatus;
    private final Double paymentAmount;
    private final LocalDateTime paymentDate;
}

