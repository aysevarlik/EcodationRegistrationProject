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
class UserRegistrationApplicationTests implements IUnitTest{

    @Autowired
    IUserRepository repository;


    @Override
    @Test
    public void saveUser() {
        UserEntity entity = UserEntity.builder().userName("ayse").userSurname("varlık")
                .userEmail("ayse@gmail.com").userPassword("asd").build();
        repository.save(entity);
        assertNotNull(repository.findByUserId(1L));
        System.out.println(repository.findByName("ayse"));
    }

    @Override
    @Test
    public void listUsers() {
        List<UserEntity> userList=repository.findAll();
        assertThat(userList).size().isGreaterThan(0);
        System.out.println(userList);
        System.out.println(repository.findByName("ayse"));
        System.out.println(repository.findByEmail("ayse@gmail.com"));
    }

    @Override
    @Test
    public void findUser() {
        UserEntity user=repository.findByUserId(1L).get();
        assertEquals("ayse",user.getUserName());
        System.out.println(user);
        System.out.println(repository.findBySurname("varlık"));
    }

    @Override
    @Test
    public void updateUser() {
        UserEntity userEntity=repository.findById(1L).get();
        userEntity.setUserName("tugce");
        repository.save(userEntity);
        assertNotEquals("ayse",repository.findById(1L).get().getUserName());
        System.out.println(repository.findByName("tugce"));

    }

    @Override
    @Test
    public void deleteUser() {
        repository.deleteById(1L);
        assertThat(repository.existsById(1L)).isFalse();
        System.out.println(repository.findAll());
    }

}
