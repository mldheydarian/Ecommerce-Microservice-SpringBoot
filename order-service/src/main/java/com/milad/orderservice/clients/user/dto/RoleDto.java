package com.milad.orderservice.clients.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoleDto   {

    private Long roleId;

    private String roleName;

    @JsonIgnore
    @JsonProperty("users")
    private List<UserDto> usersDto;


}