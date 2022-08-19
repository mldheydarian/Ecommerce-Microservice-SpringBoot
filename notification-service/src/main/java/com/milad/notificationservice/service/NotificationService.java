package com.milad.notificationservice.service;

import com.milad.notificationservice.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> findAll();

    Notification findByUserId(int id);

    Notification delete(int id);

    Notification update(Notification pd);
}
