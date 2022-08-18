package com.milad.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum PaymentStatus {


 IN_PROGRESS("in_progress"),
 COMPLETED("completed");

 private final String status;



}
