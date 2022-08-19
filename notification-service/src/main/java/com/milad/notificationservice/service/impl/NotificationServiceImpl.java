package com.milad.notificationservice.service.impl;

import com.milad.notificationservice.config.MQConfig;
import com.milad.notificationservice.model.Notification;
import com.milad.notificationservice.repository.NotificationRepository;
import com.milad.notificationservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener (Notification notification)
    {
        notificationRepository.save(notification);
        log.info("Message received :" + notification);
    }


    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
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

