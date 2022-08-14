package com.milad.orderservice.restclient.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "User", url = "http://localhost:9001/api/users")
public interface UserClientService {

    @GetMapping("/{user_name}")
    Long  getUserIdByUserName(@PathVariable("user_name") String userName);

    @GetMapping("")
    ResponseEntity<List<?>> getAllUsers();
}
