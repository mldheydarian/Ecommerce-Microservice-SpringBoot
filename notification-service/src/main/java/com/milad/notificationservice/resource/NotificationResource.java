package com.milad.notificationservice.resource;

import com.milad.notificationservice.model.Notification;
import com.milad.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/notification")
public class NotificationResource {


        @Autowired
        private NotificationService notificationService;

        @GetMapping
        public List<Notification> fildAll() {
            return notificationService.findAll();
        }



    }

