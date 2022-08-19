package com.milad.notificationservice.service.impl;

import com.milad.notificationservice.config.MQConfig;
import com.milad.notificationservice.model.Notification;
import com.milad.notificationservice.repository.NotificationRepository;
import com.milad.notificationservice.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener (Notification notification)
    {
        notificationRepository.save(notification);
    }


    @Override
    public List<Notification> findAll() {
        return null;
    }

    @Override
    public Notification findByUserId(int id) {
        return null;
    }

    @Override
    public Notification delete(int id) {
        return null;
    }

    @Override
    public Notification update(Notification pd) {
        return null;
    }
}

