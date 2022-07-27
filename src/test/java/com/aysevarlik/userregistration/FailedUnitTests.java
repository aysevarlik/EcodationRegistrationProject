package com.aysevarlik.userregistration;


import com.aysevarlik.userregistration.data.entity.UserEntity;
import com.aysevarlik.userregistration.data.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FailedUnitTests {

    @Autowired
    IUserRepository repository;

    @Test
    public void saveUserFailed(){
        UserEntity entity = UserEntity.builder()
                .userId(1L)
                .userName("nevin")
                .userSurname("samal")
                .userEmail("nevin@gmail.com")
                .userPassword("nevinsifre")
                .build();
//        repository.save(entity);
        assertThrows(AssertionFailedError.class, ()-> assertNull(repository.findByUserId(1L).get()),"registration failed");
    }

    @Test
    public void listUsersFailed(){
        List<UserEntity> list = repository.findAll();
        assertNull(list);
    }

    @Test
    public void updateUserFailed() {
        UserEntity userEntity=repository.findById(1L).get();
        userEntity.setUserName("zeynep");
        assertNotEquals("ayse",repository.findById(1L).get().getUserName());
    }

    @Test
    public void findUserFailed(){
        UserEntity user=repository.findByUserId(1L).get();
        assertNotEquals("ayse",user.getUserName());
        System.out.println(user);
    }
}
