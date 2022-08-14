package com.milad.orderservice.restclient.user.controller;

import com.milad.orderservice.restclient.user.service.UserClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Slf4j

public class UserController {
    @Autowired
     UserClientService userClientService;

    @GetMapping("/{user-name}")
    Long getUserIdByUserName(@PathVariable("user_name") String userName){
        return	userClientService.getUserIdByUserName(userName);
    }

    @GetMapping
    public ResponseEntity<?> getAllusers()
    {
        return ResponseEntity.ok(userClientService.getAllUsers());
    }

}
