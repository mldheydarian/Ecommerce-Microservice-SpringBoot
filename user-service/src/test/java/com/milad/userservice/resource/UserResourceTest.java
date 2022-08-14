package com.milad.userservice.resource;

import com.milad.userservice.dto.UserDto;
import com.milad.userservice.model.User;
import com.milad.userservice.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest()
//@RunWith(SpringRunner.class)
class UserResourceTest {
    @Autowired
    UserService userService;

// if use Autowired nested of MockBean Test Result is been Deferent
    // if use Autowired nested of MockBean will have Deferent Test Result
//    @MockBean
//    UserService userService;

    @Autowired
    UserResource userResource;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getUserById_whenUsersisExist_ShouldReturn200() throws Exception {
        //given
        User user = new User();
        user.setUserId(1l);
        user.setUserName("mili");
        //when
       // Mockito.when(userService.getUserById(1l)).thenReturn(user);
        //then
        mockMvc.perform(get("/api/users/{id}", 1l))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1l))
                .andExpect(jsonPath("$.userName").value(user.getUserName()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//        verify(userService, times(1)).getUserById(anyLong());
//        verifyNoMoreInteractions(userService);
    }


   static User dumpUser;
    @BeforeAll
    static void userDump ()
    {
        dumpUser = User.builder()
                .userId(1l)
                .userName("ahmad")
                .build();
    }
    @Test
    void getUserById_whenUsersisExist_ShouldReturnUser()
    {
       // Mockito.when(userService.getUserById(1l)).thenReturn(dumpUser);
        ResponseEntity<UserDto> user = userResource.getUserById(1l);
        Assertions.assertEquals(user.getBody().getUserName(),dumpUser.getUserName());
        Assertions.assertEquals(user.getBody().getUserId(),dumpUser.getUserId());

    }

    @Test
    public void get_user_by_id_controller_should_return404_when_users_is_notExist() throws Exception {
       // when(userService.getUserById(1l)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
         mockMvc.perform(get("/api/users/{id}", 122L))
                .andExpect(status().isNotFound());

    }

}