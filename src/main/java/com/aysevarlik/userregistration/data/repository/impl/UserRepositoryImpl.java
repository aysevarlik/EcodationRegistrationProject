package com.aysevarlik.userregistration.data.repository.impl;

import com.aysevarlik.userregistration.data.entity.UserEntity;
import com.aysevarlik.userregistration.data.repository.IUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public abstract class UserRepositoryImpl implements IUserRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<UserEntity> findAll() {
        TypedQuery<UserEntity> typedQuery = manager.createNamedQuery("UserEntity.findAll",UserEntity.class);
        List<UserEntity> list = typedQuery.getResultList();
        return list;
    }

    @Override
    public Optional<UserEntity> findByUserId(Long userId) {
        TypedQuery<UserEntity> typedQuery = manager.createNamedQuery("UserEntity.findById",UserEntity.class);
        typedQuery.setParameter("userId", userId);
        UserEntity entity = typedQuery.getSingleResult();
        return Optional.of(entity);
    }

    @Override
    public List<UserEntity> findByName(String userName) {
        TypedQuery<UserEntity> typedQuery = manager.createNamedQuery("UserEntity.findByName",UserEntity.class);
        typedQuery.setParameter("userName",userName);
        List<UserEntity> list = typedQuery.getResultList();
        return list;
    }

    @Override
    public List<UserEntity> findBySurname(String userSurname) {
        TypedQuery<UserEntity> typedQuery = manager.createNamedQuery("UserEntity.findBySurname",UserEntity.class);
        typedQuery.setParameter("userSurname",userSurname);
        List<UserEntity> list = typedQuery.getResultList();
        return list;
    }

    @Override
    public List<UserEntity> findByEmail(String userEmail) {
        TypedQuery<UserEntity> typedQuery = manager.createNamedQuery("UserEntity.findByEmail",UserEntity.class);
        typedQuery.setParameter("userEmail",userEmail);
        List<UserEntity> list = typedQuery.getResultList();
        return list;
    }
}
