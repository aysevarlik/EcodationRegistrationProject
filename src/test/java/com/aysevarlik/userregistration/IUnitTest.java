package com.aysevarlik.userregistration;

import com.aysevarlik.userregistration.data.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUnitTest {

    public void saveUser();

    public void listUsers();

    public void findUser();

    public void updateUser();

    public void deleteUser();

}
