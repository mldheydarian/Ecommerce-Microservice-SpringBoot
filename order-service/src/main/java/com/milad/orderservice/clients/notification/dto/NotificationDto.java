package com.milad.orderservice.clients.notification.dto;

import com.milad.orderservice.dto.OrderDto;
import lombok.*;

import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class NotificationDto {


   // private Long notificationId;

    private Long toUserId;
    private String toUserEmail;
    private String sender;
    private String message;
    private Date sentAt;

}
