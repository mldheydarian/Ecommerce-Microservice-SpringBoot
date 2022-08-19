package com.milad.orderservice.clients.user.service;

import com.milad.orderservice.clients.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
@FeignClient(name = "user-service", path = "/api/users")//for service discovery
//@FeignClient(name = "user-service", url = "http://localhost:9001/api/users")
public interface UserClientService {


    @GetMapping
     ResponseEntity<?> getAllUsers();

    @GetMapping("/{id}")
     ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id);



    // http://user-service/api/users/q?username=xxx&email=xxx
    @GetMapping("/q")
     ResponseEntity<UserDto> getUserByUserNameInQueryParam(@RequestParam(value = "username") String userName) ;

    // http://user-service/api/users/
    @GetMapping("/")
     ResponseEntity<UserDto> getUserByUserNameInHttpHeader(@RequestHeader Map<String, String> headers) ;

}
