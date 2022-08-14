package com.milad.userservice.resource;

import com.milad.userservice.dto.UserDto;
import com.milad.userservice.model.User;
import com.milad.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserResource {

    private  final UserService userService;

   public UserResource(UserService userService){
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos =  userService.getAllUsers();
        if(!userDtos.isEmpty()) {
            return new ResponseEntity<>(userDtos,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id)
    {
     return new ResponseEntity(userService.getUserById(id),HttpStatus.OK);

    }


    @GetMapping("/hellow")
    public ResponseEntity<String> hellowUser(){

        return new ResponseEntity<>("Hellow personality roool",HttpStatus.OK);
    }

    // http://user-service/api/users/q?username=xxx&email=xxx
    @GetMapping("/q")
    public ResponseEntity<UserDto> getUserByUserNameInQueryParam(@RequestParam(value = "username") String userName) {

      return new ResponseEntity(userService.getUserByUserName(userName),HttpStatus.OK);
    }

    // http://user-service/api/users/ setAPIKey:username=ahmad
    @GetMapping("/")
    public ResponseEntity<UserDto> getUserByUserNameInHttpHeader(@RequestHeader Map<String, String> headers) {
        return new ResponseEntity(userService.getUserByUserName(headers.get("username")),HttpStatus.OK);
    }

    // http://user-service/api/users/
    @GetMapping("/AntiAmbiguous")
    public ResponseEntity<UserDto> getUserByUserNameInToken(@RequestHeader Map<String, String> headers) {
        return new ResponseEntity(userService.getUserByUserName(headers.get("username")),HttpStatus.OK);
    }
}
