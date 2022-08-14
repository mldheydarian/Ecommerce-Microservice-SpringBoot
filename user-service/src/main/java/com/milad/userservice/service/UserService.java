package com.milad.userservice.service;

import com.milad.userservice.dto.UserDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

     UserDto getUserById(Long id);

     List<UserDto> getAllUsers();

     UserDto save(UserDto UserDto);

     UserDto getUserByUserName(String userName);


}
