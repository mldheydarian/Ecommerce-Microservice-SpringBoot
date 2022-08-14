package com.milad.userservice.repository;

import com.milad.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

     User findUserByUserName(String userName);
}
