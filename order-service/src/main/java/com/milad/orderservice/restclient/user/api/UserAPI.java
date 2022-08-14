package com.milad.orderservice.restclient.user.api;

import com.milad.orderservice.restclient.user.dto.UserDto;
import com.milad.orderservice.restclient.user.service.UserClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Slf4j

public class UserAPI {
    @Autowired
     UserClientService userClientService;

    @GetMapping
    public ResponseEntity<?> getAllUsers()
    {
        return ResponseEntity.ok(userClientService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id)
    {
        return new ResponseEntity(userClientService.getUserById(id), HttpStatus.OK);
    }



    // http://user-service/api/users/q?username=xxx&email=xxx
    @GetMapping("/q")
    public ResponseEntity<UserDto> getUserByUserNameInQueryParam(@RequestParam(value = "username") String userName) {

        return new ResponseEntity(userClientService.getUserByUserNameInQueryParam(userName),HttpStatus.OK);
    }

    // http://user-service/api/users/
    @GetMapping("/")
    public ResponseEntity<UserDto> getUserByUserNameInHttpHeader(@RequestHeader Map<String, String> headers) {
        return new ResponseEntity(userClientService.getUserByUserNameInHttpHeader(headers),HttpStatus.OK);
    }

}
