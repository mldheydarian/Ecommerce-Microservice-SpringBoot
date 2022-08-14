package com.milad.orderservice.restclient.user.service;

import com.milad.orderservice.restclient.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(name = "User", url = "http://localhost:9001/api/users")
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
