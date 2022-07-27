package com.aysevarlik.userregistration.rest;

import com.aysevarlik.userregistration.data.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IRestImpl {

    //save
    UserEntity createUser(UserEntity userEntity);

    //list
    List<UserEntity> getAllUsers();

    //find
    ResponseEntity<UserEntity> getUserById(Long id);

    //update
    ResponseEntity<UserEntity> updateUser(Long id,UserEntity userEntity);

    //delete
    ResponseEntity<Map<String,Boolean>> deleteUser(Long id);
}
