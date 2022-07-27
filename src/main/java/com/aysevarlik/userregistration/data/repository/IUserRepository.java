package com.aysevarlik.userregistration.data.repository;

import com.aysevarlik.userregistration.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    public List<UserEntity> findAll();
    public Optional<UserEntity> findByUserId(Long userId);
    public List<UserEntity> findByName(String userName);
    public List<UserEntity> findBySurname (String userSurname);
    public List<UserEntity> findByEmail (String userEmail);
}
